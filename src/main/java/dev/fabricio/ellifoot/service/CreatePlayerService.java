package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.request.CreatePlayerRequest;
import dev.fabricio.ellifoot.controller.response.PlayerResponse;
import dev.fabricio.ellifoot.entity.Club;
import dev.fabricio.ellifoot.entity.Player;
import dev.fabricio.ellifoot.mapper.ClubMapper;
import dev.fabricio.ellifoot.mapper.PlayerMapper;
import dev.fabricio.ellifoot.repository.ClubRepository;
import dev.fabricio.ellifoot.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CreatePlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final FindClubService findClubService;

    public CreatePlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper, FindClubService findClubService) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.findClubService = findClubService;
    }

    public PlayerResponse execute(CreatePlayerRequest request) {
        Player newPlayer = playerMapper.toPlayer(request);
        newPlayer.setClub(findClubService.findClubById(request.clubId()));
        Player savedPlayer = playerRepository.save(newPlayer);
        return playerMapper.toPlayerResponse(savedPlayer);

    }

}
