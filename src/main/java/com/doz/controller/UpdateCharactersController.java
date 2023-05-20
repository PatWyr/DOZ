package com.doz.controller;

import com.doz.model.ResponseDto;
import com.doz.service.RetrieveCharactersFromApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UpdateCharactersController {
    private final RetrieveCharactersFromApiService retrieveCharactersFromApiService;

    @PostMapping("/update")
    ResponseEntity<ResponseDto> updateDBWithCharacters() {
        log.info("Updating DB with data from API");
        return retrieveCharactersFromApiService.retrieve();
    }

}
