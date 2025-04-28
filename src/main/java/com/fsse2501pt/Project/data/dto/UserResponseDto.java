package com.fsse2501pt.Project.data.dto;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class UserResponseDto {
    private String firebaseUid;
    private String email;
    private String issuer;

    public UserResponseDto(JwtAuthenticationToken jwtToken) {
        this.firebaseUid = (String) jwtToken.getTokenAttributes().get("user_id");
        this.email = (String) jwtToken.getTokenAttributes().get("email");
        this.issuer = (String) jwtToken.getTokenAttributes().get("iss");
    }

}










