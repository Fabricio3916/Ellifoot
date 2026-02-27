package dev.fabricio.ellifoot.mapper;

import dev.fabricio.ellifoot.controller.response.ClubResponse;
import dev.fabricio.ellifoot.entity.Club;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClubMapperTest {

    private final ClubMapper clubMapper = Mappers.getMapper(ClubMapper.class);

    @Test
    void toClubResponse() {
        //AAA
        //Arrange
        Club club =  Club.builder()
                .id(1L)
                .name("Test Club")
                .founded(LocalDate.parse("2026-02-27"))
                .urlImg("Test URL")
                .build();

        //Action
        ClubResponse clubResponse = clubMapper.toClubResponse(club);

        //Assertion
        assertNotNull(clubResponse);
        assertEquals(club.getId(),clubResponse.id());
        assertEquals(club.getName(),clubResponse.name());
        assertEquals(club.getFounded(),clubResponse.founded());
        assertEquals(club.getUrlImg(),clubResponse.urlImg());


    }

    @Test
    void toClubDetailResponse() {
    }

    @Test
    void toClub() {
    }
}