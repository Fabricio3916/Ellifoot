package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.response.ClubDetailResponse;
import dev.fabricio.ellifoot.controller.response.ClubResponse;
import dev.fabricio.ellifoot.entity.Club;
import dev.fabricio.ellifoot.exception.ResourceNotFoundException;
import dev.fabricio.ellifoot.mapper.ClubMapper;
import dev.fabricio.ellifoot.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public FindClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public Page<ClubResponse> findall(Pageable pageable) {
       return clubRepository.findAll(pageable).map(clubMapper::toClubResponse);
    }

    public ClubDetailResponse findById(Long id){
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found for id: " + id));
        return clubMapper.toClubDetailResponse(club);

    }

}
