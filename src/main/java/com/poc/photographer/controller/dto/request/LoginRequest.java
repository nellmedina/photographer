package com.poc.photographer.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @Size(min=3, max = 100)
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}