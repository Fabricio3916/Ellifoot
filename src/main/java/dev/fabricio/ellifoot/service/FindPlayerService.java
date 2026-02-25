package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.response.PlayerDetailResponse;
import dev.fabricio.ellifoot.controller.response.PlayerResponse;
import dev.fabricio.ellifoot.exception.ResourceNotFoundException;
import dev.fabricio.ellifoot.mapper.PlayerMapper;
import dev.fabricio.ellifoot.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class FindPlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public FindPlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public Page<PlayerResponse> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable)
                .map(playerMapper::toPlayerResponse);
    }

    public PlayerDetailResponse findById(Long id) {
        return playerRepository.findById(id)
                .map(playerMapper::toPlayerDetailResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found for id: " + id));
    }

    public List<PlayerResponse> findPlayersByClubId(@PathVariable Long id){
        return playerRepository.findByClubId(id)
                .stream()
                .map(playerMapper::toPlayerResponse)
                .toList();
    }

}
