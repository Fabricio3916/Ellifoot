package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.request.CreateStadiumRequest;
import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.entity.Stadium;
import dev.fabricio.ellifoot.mapper.StadiumMapper;
import dev.fabricio.ellifoot.repository.StadiumRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public CreateStadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public StadiumResponse execute(CreateStadiumRequest request) {
        Stadium stadium = stadiumRepository.save(stadiumMapper.toStadium(request));
        return stadiumMapper.toStadiumResponse(stadium);
    }

}
