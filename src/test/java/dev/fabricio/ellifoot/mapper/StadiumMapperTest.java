package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.request.CreateStadiumRequest;
import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.entity.Stadium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StadiumMapperTest {

    private final StadiumMapper stadiumMapper = Mappers.getMapper(StadiumMapper.class);

    @Test
    @DisplayName("toStadiumResponse should map Stadium to StadiumResponse correctly")
    void toStadiumResponse() {
        //Arrange - Given
        Stadium stadium = Stadium.builder()
                .id(1L)
                .name("Test Stadium")
                .city("Test City")
                .capacity(50000)
                .urlImg("Test URL")
                .build();
        //Action - When
        StadiumResponse response = stadiumMapper.toStadiumResponse(stadium);

        // Assertions - Then
        assertNotNull(response);
        assertEquals(stadium.getId(),response.id());
        assertEquals(stadium.getName(),response.name());
        assertEquals(stadium.getCity(),response.city());
        assertEquals(stadium.getCapacity(),response.capacity());
        assertEquals(stadium.getUrlImg(), response.urlImg());

    }

    @Test
    @DisplayName("toStadium should map CreateStadiumRequest to Stadium correctly")
    void toStadium() {

        //Arrange
        CreateStadiumRequest request = CreateStadiumRequest.builder()
                .name("Test Stadium")
                .city("Test City")
                .capacity(5000)
                .urlImg("Test URL")
                .build();

        //Action
        Stadium stadium = stadiumMapper.toStadium(request);

        assertNotNull(stadium);
        assertEquals(request.name(), stadium.getName());
        assertEquals(request.city(), stadium.getCity());
        assertEquals(request.capacity(), stadium.getCapacity());
        assertEquals(request.urlImg(), stadium.getUrlImg());

    }
}