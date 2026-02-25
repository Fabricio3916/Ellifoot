package dev.fabricio.ellifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public record PlayerDetailResponse(

        Long id,
        String name,
        String position,
        int shirtNumber,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String urlImg,
        ClubBasicResponse club


) {
}
