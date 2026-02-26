package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.controller.request.LoginRequest;
import dev.fabricio.ellifoot.controller.response.LoginResponse;
import dev.fabricio.ellifoot.entity.Scope;
import dev.fabricio.ellifoot.entity.User;
import dev.fabricio.ellifoot.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    public LoginResponse login(@Valid LoginRequest request)  {
        Optional<User> optUser = userRepository.findByEmail(request.email());
        if(optUser.isEmpty() || !isPasswordCorrect(request.password(),  optUser.get().getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }
        User user = optUser.get();
        List<String> scopes = user.getScopes()
                .stream()
                .map(Scope::getName)
                .toList();
        long expiresIn = 600L;

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("elifoot-api")
                .subject(user.getName())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .issuedAt(Instant.now())
                .claim("scope", scopes)
                .claim("email", user.getEmail())
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();
        return LoginResponse.builder()
                .accessToken(token)
                .expiresIn(expiresIn)
                .build();
    }

    private boolean isPasswordCorrect(String password, String savedPassword) {
        return passwordEncoder.matches(password, savedPassword);
    }

}
