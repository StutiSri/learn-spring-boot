package com.learn.springboot.api.callback;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.function.Function;

public class MappableCommandCallback<C, R> extends DeferredResult<R> implements CommandCallback<C, R> {

    Function<C, R> mapper;

    public MappableCommandCallback(Function<C, R> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void onSuccess(CommandMessage commandMessage, Object o) {
        setResult(mapper.apply((C) o));
    }

    @Override
    public void onFailure(CommandMessage commandMessage, Throwable throwable) {
        setErrorResult(throwable);
    }
}
