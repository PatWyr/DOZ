package com.doz.controller;

import com.doz.model.CharacterDto;
import com.doz.service.RetrieveCharactersFromDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RetrieveCharactersController {
    private final RetrieveCharactersFromDB retrieveCharactersFromDB;

    @GetMapping("/retrieve/{characterName}")
    ResponseEntity<List<CharacterDto>> retrieveCharacterFromDB(@PathVariable String characterName) {
        log.info("Retrieving: " + characterName + " from DB");
        List<CharacterDto> response = retrieveCharactersFromDB.retrieve(characterName);
        return ResponseEntity.ok(response);
    }
}
