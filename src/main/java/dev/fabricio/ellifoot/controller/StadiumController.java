package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.request.CreateStadiumRequest;
import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.service.CreateStadiumService;
import dev.fabricio.ellifoot.service.FindStadiumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;

    public StadiumController(FindStadiumService findStadiumService, CreateStadiumService createStadiumService) {
        this.findStadiumService = findStadiumService;
        this.createStadiumService = createStadiumService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> getStadiums(Pageable pageable) {
        return findStadiumService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse createStadium(@Valid @RequestBody CreateStadiumRequest request) {
        return createStadiumService.execute(request);
    }



}
