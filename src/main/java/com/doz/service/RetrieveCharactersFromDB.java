package com.doz.service;

import com.doz.model.CharacterDto;
import com.doz.model.entity.CharacterEntity;
import com.doz.repository.CharacterEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveCharactersFromDB implements RetrieveFromDB<List<CharacterDto>, String> {
    private final CharacterEntityRepository characterEntityRepository;

    @Override
    public List<CharacterDto> retrieve(String param) {
        List<Optional<CharacterEntity>> entity = characterEntityRepository.findAllByName(param);
        return entity.stream().filter(Optional::isPresent).map(Optional::get).map(CharacterDto::toDto).toList();
    }
}
