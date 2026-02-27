package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.mapper.ClubMapper;
import dev.fabricio.ellifoot.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateClubServiceTest {

    @InjectMocks
    CreateClubService createClubService;
    @Mock
    ClubRepository clubRepository;
    @Mock
    ClubMapper clubMapper;
    @Mock
    FindClubService findClubService;


    @Test
    void execute() {

        createClubService.execute(null);

    }
}