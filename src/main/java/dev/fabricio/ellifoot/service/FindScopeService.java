package dev.fabricio.ellifoot.service;

import dev.fabricio.ellifoot.entity.Scope;
import dev.fabricio.ellifoot.exception.ResourceNotFoundException;
import dev.fabricio.ellifoot.repository.ScopeRepository;
import org.springframework.stereotype.Service;

@Service
public class FindScopeService {

    private final ScopeRepository scopeRepository;

    public FindScopeService(ScopeRepository scopeRepository) {
        this.scopeRepository = scopeRepository;
    }

    public Scope findById(Long id) {
        return scopeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scope not found for id: " + id));
    }

}
