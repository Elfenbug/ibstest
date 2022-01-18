package ru.ibs.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    private Long id;
    private String lastname;
    private String name;
    private String patronymic;
    private String birthday;
}
