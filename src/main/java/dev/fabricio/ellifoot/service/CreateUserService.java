package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.request.CreateUserRequest;
import dev.fabricio.ellifoot.controller.response.UserResponse;
import dev.fabricio.ellifoot.entity.Scope;
import dev.fabricio.ellifoot.entity.User;
import dev.fabricio.ellifoot.exception.EmailAlreadyExistException;
import dev.fabricio.ellifoot.mapper.UserMapper;
import dev.fabricio.ellifoot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    private final FindScopeService findScopeService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(UserRepository userRepository, FindScopeService findScopeService, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.findScopeService = findScopeService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse execute(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistException("Email already registered, please try again");
        }

       List<Scope> scopes = request.scopes().stream()
                .map(findScopeService::findById)
                .toList();

        User newUser = userMapper.toEntity(request);
        newUser.setScopes(scopes);
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setActive(true);
        User savedUser = userRepository.save(newUser);
        return userMapper.toResponse(savedUser);


    }

}
