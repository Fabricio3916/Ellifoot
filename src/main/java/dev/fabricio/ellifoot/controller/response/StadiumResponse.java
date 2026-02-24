package dev.fabricio.ellifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public record StadiumResponse(
        Long id,
        String name,
        String city,
        Integer capacity,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String urlImg
) {}
