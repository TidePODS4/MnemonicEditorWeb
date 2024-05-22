package ru.graduation.graduationprojecttestapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import ru.graduation.graduationprojecttestapp.entity.Schema;
import ru.graduation.graduationprojecttestapp.repository.SchemaRepo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
    public Resource getSvgBySchemaId(UUID schemaId) {
        String url = svgMakerBaseUrl + "/schemas/" + schemaId + "/svg";
        return restTemplate.getForObject(url, Resource.class);
    }
}
