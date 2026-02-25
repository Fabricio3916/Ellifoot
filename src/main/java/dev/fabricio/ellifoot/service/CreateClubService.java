package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.request.CreateClubRequest;
import dev.fabricio.ellifoot.controller.response.ClubDetailResponse;
import dev.fabricio.ellifoot.entity.Club;
import dev.fabricio.ellifoot.entity.Stadium;
import dev.fabricio.ellifoot.mapper.ClubMapper;
import dev.fabricio.ellifoot.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final FindStadiumService findStadiumService;

    public CreateClubService(ClubRepository clubRepository, ClubMapper clubMapper, FindStadiumService findStadiumService) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
        this.findStadiumService = findStadiumService;
    }

    public ClubDetailResponse execute(CreateClubRequest request){
        Club club = clubMapper.toClub(request);
        if(Objects.nonNull(club.getStadium())){
            club.setStadium(findStadiumService.findById(club.getStadium().getId()));
        }
        Club savedClub = clubRepository.save(club);
        return clubMapper.toClubDetailResponse(savedClub);
    }

}
