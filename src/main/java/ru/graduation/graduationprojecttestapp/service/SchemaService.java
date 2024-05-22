package ru.graduation.graduationprojecttestapp.service;

import ru.graduation.graduationprojecttestapp.entity.Schema;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface SchemaService {
    List<Schema> findAll();
    String getSvgBySchemaId(UUID schemaId) throws IOException;
}
