package dev.fabricio.ellifoot.controller.request;

import dev.fabricio.ellifoot.entity.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePlayerRequest(

        @NotBlank
        String name,
        @NotNull
        Position position,
        @NotNull
        int shirtNumber,
        String urlImg,
        @NotNull
        Long clubId

) {
}
