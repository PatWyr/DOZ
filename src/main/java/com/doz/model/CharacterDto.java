package com.doz.model;

import com.doz.model.entity.CharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDto origin;
    private LocationDto location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    public CharacterEntity toEntity() {
        return CharacterEntity
                .builder()
                .id(id)
                .name(name)
                .status(status)
                .species(species)
                .type(type)
                .gender(gender)
                .origin(origin.toEntity())
                .location(location.toEntity())
                .image(image)
                .episode(episode)
                .url(url)
                .created(created)
                .build();
    }

    public static CharacterDto toDto(CharacterEntity entity) {
        return CharacterDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .species(entity.getSpecies())
                .type(entity.getType())
                .gender(entity.getGender())
                .origin(OriginDto.toDto(entity.getOrigin()))
                .location(LocationDto.toDto(entity.getLocation()))
                .image(entity.getImage())
                .episode(entity.getEpisode())
                .url(entity.getUrl())
                .created(entity.getCreated())
                .build();
    }
}
