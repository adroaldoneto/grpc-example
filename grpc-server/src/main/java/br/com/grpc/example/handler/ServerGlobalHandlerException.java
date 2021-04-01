package br.com.grpc.example.handler;

import br.com.grpc.example.exception.NotFoundException;
import com.google.rpc.Code;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ServerGlobalHandlerException {

    @GrpcExceptionHandler(NotFoundException.class)
    public StatusRuntimeException exceptionHandler(NotFoundException exception) {

        var status = Status.NOT_FOUND
                .withDescription(exception.getErrorCode().getValue())
                .augmentDescription(exception.getErrorCode().getCode());

        return new StatusRuntimeException(status);
    }
}
