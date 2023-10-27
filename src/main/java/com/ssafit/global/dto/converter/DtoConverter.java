package com.ssafit.global.dto.converter;

@FunctionalInterface
public interface DtoConverter<T, R> {

    R convert(T obj);
}