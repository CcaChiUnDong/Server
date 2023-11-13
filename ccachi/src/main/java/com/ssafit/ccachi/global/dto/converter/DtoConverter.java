package com.ssafit.ccachi.global.dto.converter;

@FunctionalInterface
public interface DtoConverter<T, R> {

    R convert(T obj);
}