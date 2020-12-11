package com.poc.photographer.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse extends BaseResponse{
    private Long userId;
    private String token;
    private String type = "Bearer";
    private String email;

    public LoginResponse(String token) {
        this.token = token;
    }
}