package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.mapper.StadiumMapper;
import dev.fabricio.ellifoot.repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindStadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public FindStadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public Page<StadiumResponse> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable)
                .map(stadiumMapper::toStadiumResponse);
    }

}
