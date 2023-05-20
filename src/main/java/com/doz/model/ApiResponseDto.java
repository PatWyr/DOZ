package com.doz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ApiResponseDto {
    private InfoDto info;
    private List<CharacterDto> results;
}
