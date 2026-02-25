package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.request.CreateClubRequest;
import dev.fabricio.ellifoot.controller.response.ClubResponse;
import dev.fabricio.ellifoot.controller.response.ClubDetailResponse;
import dev.fabricio.ellifoot.service.CreateClubService;
import dev.fabricio.ellifoot.service.FindClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;

    public ClubController(FindClubService findClubService, CreateClubService createClubService) {
        this.findClubService = findClubService;
        this.createClubService = createClubService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable) {
        return findClubService.findall(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubDetailResponse findById(@PathVariable Long id){
        return findClubService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse create(@RequestBody CreateClubRequest request){
        return createClubService.execute(request);
    }


}
