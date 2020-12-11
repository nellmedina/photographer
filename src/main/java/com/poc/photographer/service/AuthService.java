package com.poc.photographer.service;

import com.poc.photographer.controller.dto.request.LoginRequest;
import com.poc.photographer.controller.dto.request.SignUpRequest;
import com.poc.photographer.controller.dto.response.BaseResponse;
import com.poc.photographer.controller.dto.response.LoginResponse;
import com.poc.photographer.model.Role;
import com.poc.photographer.model.RoleName;
import com.poc.photographer.model.UserEntity;
import com.poc.photographer.repository.RoleRepository;
import com.poc.photographer.repository.UserRepository;
import com.poc.photographer.security.jwt.JwtProvider;
import com.poc.photographer.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private
    RoleRepository roleRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private
    AuthenticationManager authenticationManager;

    @Autowired
    private
    PasswordEncoder encoder;

    public ResponseEntity<?> signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return
                    new ResponseEntity<BaseResponse>(
                            new BaseResponse(
                                    false,
                                    "Email is already in use!"),
                            HttpStatus.BAD_REQUEST
                    );
        }

        UserEntity user = new UserEntity();
        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleName(RoleName.CUSTOMER.toString())
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        if (strRoles != null) {
            strRoles.forEach(role -> {
                switch (role) {
                    case "photographer":
                        Role adminRole = roleRepository.findByRoleName(RoleName.PHOTOGRAPHER.toString())
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                        roles.add(adminRole);
                        break;
                    default:
                        break;
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        return
                new ResponseEntity<BaseResponse>(
                        new BaseResponse(
                                true,
                                "SignUp Successful!"),
                        HttpStatus.OK
                );
    }

    public ResponseEntity<?> signIn(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        LoginResponse loginResponse = new LoginResponse(jwt);
        loginResponse.setMessage("Authenticated");
        loginResponse.setUserId(userPrincipal.getId());
        loginResponse.setEmail(userPrincipal.getEmail());
        return ResponseEntity.ok(loginResponse);
    }

}
