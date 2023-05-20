package com.doz.service;

import com.doz.model.ApiResponseDto;
import com.doz.model.CharacterDto;
import com.doz.model.ResponseDto;
import com.doz.repository.CharacterEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class RetrieveCharactersFromApiService implements RetrieveService<ResponseEntity<ResponseDto>> {
    private final WebClient rickAndMortyApi;
    private final CharacterEntityRepository characterEntityRepository;

    @Override
    public ResponseEntity<ResponseDto> retrieve() {
        ApiResponseDto response = rickAndMortyApi.get().uri(uriBuilder ->
                        uriBuilder.path("/character").build())
                .retrieve()
                .bodyToMono(ApiResponseDto.class)
                .block();

        int pages = Objects.requireNonNull(response).getInfo().getPages();

        Flux<ApiResponseDto> flux = Flux.fromStream(IntStream.range(1, pages).boxed())
                .flatMap(integer -> rickAndMortyApi.get().uri(uriBuilder ->
                                uriBuilder.path("/character")
                                        .queryParam("page", integer)
                                        .build())
                        .retrieve()
                        .bodyToFlux(ApiResponseDto.class));
        flux.collectList().subscribe(this::saveInDb);
        return ResponseEntity.ok(ResponseDto.builder()
                .httpStatus(HttpStatus.OK)
                .message("Update database from API").build());
    }

    private void saveInDb(List<ApiResponseDto> response) {
        assert response != null;
        List<CharacterDto> results = response
                .stream()
                .map(ApiResponseDto::getResults)
                .flatMap(List::stream)
                .toList();
        results.forEach(characterDto -> characterEntityRepository.save(characterDto.toEntity()));
    }
}
