package com.projeto.teste.neogridfile.mapper;

import org.springframework.core.convert.converter.Converter;

import java.util.List;

public interface MapLineToObject<T> extends Converter<String,T> {
}
