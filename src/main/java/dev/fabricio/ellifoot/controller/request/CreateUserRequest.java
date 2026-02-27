package dev.fabricio.ellifoot.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateUserRequest(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank
        String password,
        @NotEmpty
        List<Long> scopes
) {
}
