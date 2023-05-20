package com.doz.model;

import com.doz.model.entity.OriginEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OriginDto {
    private String name;
    private String url;

    OriginEntity toEntity() {
        return OriginEntity
                .builder()
                .name(name)
                .url(url)
                .build();
    }

    static OriginDto toDto(OriginEntity entity) {
        return OriginDto
                .builder()
                .name(entity.getName())
                .url(entity.getUrl())
                .build();

    }

}
