package br.com.grpc.example.exception;

import br.com.grpc.example.constant.ConstantErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode.getValue());
        this.errorCode = errorCode;
    }
}
