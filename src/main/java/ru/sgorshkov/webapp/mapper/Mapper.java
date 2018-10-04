package ru.sgorshkov.webapp.mapper;

public interface Mapper<SOURCE,TARGET> {

    TARGET convert(SOURCE s);

    Iterable<TARGET> convertAll(Iterable<SOURCE> s);
}
