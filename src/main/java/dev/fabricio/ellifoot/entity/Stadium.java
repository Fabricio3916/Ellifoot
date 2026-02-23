package dev.fabricio.ellifoot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_seq")
    @SequenceGenerator(name = "stadium_seq", sequenceName = "stadium_seq", allocationSize = 1)
    private long id;

    private String name;

    private String city;

    private Integer capacity;

    @Column(name = "url_img")
    private String urlImage;

}
