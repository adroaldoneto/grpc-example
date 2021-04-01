package br.com.grpc.example.handler;

import br.com.grpc.example.response.error.ErrorCodeResponse;
import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientGlobalExceptionHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorCodeResponse exceptionHandler(StatusRuntimeException statusRuntimeException) {
        var message = statusRuntimeException.getMessage();
        return new ErrorCodeResponse(message);
    }
}
