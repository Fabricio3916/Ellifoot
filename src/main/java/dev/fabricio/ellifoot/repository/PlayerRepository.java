package dev.fabricio.ellifoot.repository;

import dev.fabricio.ellifoot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
