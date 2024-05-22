package ru.graduation.graduationprojecttestapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.graduation.graduationprojecttestapp.entity.Schema;
import ru.graduation.graduationprojecttestapp.repository.SchemaRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchemaServiceImpl implements SchemaService {
    private final SchemaRepo schemaRepo;
    private final RestTemplate restTemplate;

    @Value("${svg-maker.base-url}")
    private String svgMakerBaseUrl;

    @Override
    public List<Schema> findAll() {
        return schemaRepo.findAll();
    }

    @Override
    public String getSvgBySchemaId(UUID schemaId) throws IOException {
        String url = svgMakerBaseUrl + "/schemas/" + schemaId + "/svg";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(restTemplate.getForObject(url, Resource.class).getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
