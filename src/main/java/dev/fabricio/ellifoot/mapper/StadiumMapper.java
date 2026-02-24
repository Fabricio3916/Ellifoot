package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.entity.Stadium;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StadiumMapper {

    public static StadiumResponse toStadiumResponse(Stadium stadium) {
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImage())
                .build();
    }

}
