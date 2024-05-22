package ru.graduation.graduationprojecttestapp.repository;

import ru.graduation.graduationprojecttestapp.entity.Schema;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SchemaRepo {
    List<Schema> findAll();
    Optional<Schema> findById(UUID id);
}
