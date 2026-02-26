package dev.fabricio.ellifoot.controller.response;

import lombok.Builder;

@Builder
public record LoginResponse(
        String accessToken,
        Long expiresIn
) {}
