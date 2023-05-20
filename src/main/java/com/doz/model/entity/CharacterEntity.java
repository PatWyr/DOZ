package com.doz.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "characters")
public class CharacterEntity {
    @Id
    private Long id;

    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_name")
    private OriginEntity origin;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_name")
    private LocationEntity location;
    private String image;
    @ElementCollection
    private List<String> episode;
    private String url;
    private String created;

}
