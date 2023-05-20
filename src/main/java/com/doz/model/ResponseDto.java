package com.doz.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ResponseDto {
    private String message;
    private HttpStatus httpStatus;
}
