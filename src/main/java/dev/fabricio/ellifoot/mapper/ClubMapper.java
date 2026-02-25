package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.request.CreateClubRequest;
import dev.fabricio.ellifoot.controller.response.ClubDetailResponse;
import dev.fabricio.ellifoot.controller.response.ClubResponse;
import dev.fabricio.ellifoot.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    ClubResponse toClubResponse(Club club);

    ClubDetailResponse toClubDetailResponse(Club club);

    @Mapping(target = "stadium.id", source = "stadiumId")
    Club toClub(CreateClubRequest request);


}
