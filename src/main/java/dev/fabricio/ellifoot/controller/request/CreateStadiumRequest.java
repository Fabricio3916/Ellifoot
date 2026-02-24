package dev.fabricio.ellifoot.controller.request;


import jakarta.validation.constraints.NotBlank;

public record CreateStadiumRequest(

        @NotBlank
        String name,
        @NotBlank
        String city,
        Integer capacity,
        String urlImg

) {
}
