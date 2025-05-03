package com.fsse2501pt.Project.api;

import com.fsse2501pt.Project.data.dto.UserResponseDto;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {
    @GetMapping("/me/details")
    public UserResponseDto getMyUserDetails(JwtAuthenticationToken jwtToken) {
        UserResponseDto loginUser = new UserResponseDto(jwtToken);
        return loginUser;
    }
}


