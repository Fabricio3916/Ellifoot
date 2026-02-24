package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.response.StadiumResponse;
import dev.fabricio.ellifoot.entity.Stadium;
import dev.fabricio.ellifoot.service.FindStadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final FindStadiumService findStadiumService;

    public StadiumController(FindStadiumService findStadiumService) {
        this.findStadiumService = findStadiumService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<StadiumResponse> getStadiums(Pageable pageable) {
        return findStadiumService.findAll(pageable);
    }

}
