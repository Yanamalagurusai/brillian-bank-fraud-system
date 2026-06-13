package com.brillian.auth.dto;

import com.brillian.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String tokenType;
    private Long id;
    private String name;
    private String email;
    private Role role;
}
