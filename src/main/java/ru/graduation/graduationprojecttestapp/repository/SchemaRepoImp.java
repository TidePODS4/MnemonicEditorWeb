package ru.graduation.graduationprojecttestapp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.graduation.graduationprojecttestapp.entity.Schema;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SchemaRepoImp implements SchemaRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Schema> findAll() {
        return jdbcTemplate.query(
                "select * from schemas",
                Map.of(),
                new BeanPropertyRowMapper<>(Schema.class));
    }

    @Override
    public Optional<Schema> findById(UUID id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("""
                select * from schemas
                where id = :id
                """,
                Map.of("id", id),
                new BeanPropertyRowMapper<>(Schema.class)));
    }
}
