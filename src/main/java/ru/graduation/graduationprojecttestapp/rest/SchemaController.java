package ru.graduation.graduationprojecttestapp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.graduation.graduationprojecttestapp.entity.Schema;
import ru.graduation.graduationprojecttestapp.service.SchemaService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class SchemaController {
    private final SchemaService schemaService;

    @GetMapping()
    public String getMainPage(Model model) {
        List<Schema> schemas = schemaService.findAll();
        model.addAttribute("schemas", schemas);

        return "main_page";
    }

    @GetMapping(value = "/schemas/{schemaId}")
    public String drawSvg(@PathVariable UUID schemaId, Model model) throws IOException {
        String svgContent = schemaService.getSvgBySchemaId(schemaId);
        model.addAttribute("svgContent", svgContent);
        return "schema_page";
    }
}
