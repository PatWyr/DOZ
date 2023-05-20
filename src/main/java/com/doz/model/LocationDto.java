package com.doz.model;

import com.doz.model.entity.LocationEntity;
import com.doz.model.entity.OriginEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {
    private String name;
    private String url;

    LocationEntity toEntity() {
        return LocationEntity
                .builder()
                .name(name)
                .url(url)
                .build();
    }

    static LocationDto toDto(LocationEntity entity) {
        return LocationDto
                .builder()
                .name(entity.getName())
                .url(entity.getUrl())
                .build();

    }
}
