package br.com.grpc.example.handler;

import br.com.grpc.example.exception.NotFoundException;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GlobalHandlerException {

    @GrpcExceptionHandler(NotFoundException.class)
    public StatusRuntimeException exceptionHandler(NotFoundException exception) {
        return new StatusRuntimeException(Status.NOT_FOUND);
    }
}
