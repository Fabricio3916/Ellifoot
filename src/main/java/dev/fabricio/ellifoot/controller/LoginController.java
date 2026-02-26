package dev.fabricio.ellifoot.controller;

import dev.fabricio.ellifoot.controller.request.LoginRequest;
import dev.fabricio.ellifoot.controller.response.LoginResponse;
import dev.fabricio.ellifoot.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return loginService.login(request);
    }

}
