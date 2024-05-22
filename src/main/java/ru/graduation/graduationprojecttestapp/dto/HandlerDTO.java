package ru.graduation.graduationprojecttestapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HandlerDTO {
    private UUID primitiveId;
    private UUID handlerId;
    private String name;
    private String description;
}
