package br.com.grpc.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorCode {
    private String code;
    private String value;
}