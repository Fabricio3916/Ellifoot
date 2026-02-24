package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.request.CreateStadiumRequest;
import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.entity.Stadium;
import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

    StadiumResponse toStadiumResponse(Stadium stadium);

    Stadium toStadium(CreateStadiumRequest stadiumRequest);

}
