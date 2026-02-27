package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.request.CreateUserRequest;
import dev.fabricio.ellifoot.controller.response.UserResponse;
import dev.fabricio.ellifoot.service.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserService createUserService;

    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody CreateUserRequest request) {
        return createUserService.execute(request);
    }

}
