package dev.fabricio.ellifoot.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateClubRequest(

        @NotBlank
        String name,
        @NotNull
        LocalDate founded,
        String urlImg,
        Long stadiumId

) {
}
