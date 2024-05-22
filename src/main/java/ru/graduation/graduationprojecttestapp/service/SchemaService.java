package ru.graduation.graduationprojecttestapp.service;

import org.springframework.core.io.Resource;
import ru.graduation.graduationprojecttestapp.entity.Schema;

import java.util.List;
import java.util.UUID;

public interface SchemaService {
    List<Schema> findAll();
    Resource getSvgBySchemaId(UUID schemaId);
}
