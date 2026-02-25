package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.request.CreatePlayerRequest;
import dev.fabricio.ellifoot.controller.response.PlayerDetailResponse;
import dev.fabricio.ellifoot.controller.response.PlayerResponse;
import dev.fabricio.ellifoot.service.CreatePlayerService;
import dev.fabricio.ellifoot.service.FindPlayerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final FindPlayerService findPlayerService;
    private final CreatePlayerService createPlayerService;

    public PlayerController(FindPlayerService findPlayerService, CreatePlayerService createPlayerService) {
        this.findPlayerService = findPlayerService;
        this.createPlayerService = createPlayerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PlayerResponse> findAll(Pageable pageable) {
        return findPlayerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDetailResponse findById(@PathVariable Long id) {
        return findPlayerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse create(@Valid @RequestBody CreatePlayerRequest request) {
        return createPlayerService.execute(request);
    }


}
