package dev.fabricio.ellifoot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Position position;

    private int shirtNumber;

    @Column(name = "url_img")
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
