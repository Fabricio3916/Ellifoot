package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.request.CreatePlayerRequest;
import dev.fabricio.ellifoot.controller.response.PlayerDetailResponse;
import dev.fabricio.ellifoot.controller.response.PlayerResponse;
import dev.fabricio.ellifoot.entity.Player;
import dev.fabricio.ellifoot.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayerResponse toPlayerResponse(Player player);

    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayerDetailResponse toPlayerDetailResponse(Player player);

    @Mapping(target = "club.id", source = "clubId")
    Player toPlayer(CreatePlayerRequest request);

    @Named("enumToString")
    default String enumToString(Position position) {
        return position != null ? position.getLabel() : null;
    }




}
