package com.projeto.teste.neogridfile.mapper;

import com.google.common.base.Function;

public interface MapLineToObject<T> {
    Function<String, T> getFunction();
}
