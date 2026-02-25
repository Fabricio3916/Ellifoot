package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.response.PositionResponse;
import dev.fabricio.ellifoot.entity.Position;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("resources")
public class ResourceController {

    @GetMapping("/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponse> getPositions() {
        return Arrays.stream(Position.values())
                .map(position -> new PositionResponse(position.name(), position.getLabel()))
                .toList();
    }

}
