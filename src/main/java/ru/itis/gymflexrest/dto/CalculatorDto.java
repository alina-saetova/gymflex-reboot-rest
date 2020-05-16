package ru.itis.gymflexrest.dto;

import lombok.Data;

@Data
public class CalculatorDto {

    private String gender;
    private String formula;
    private Double weight;
    private int height;
    private int age;
    private String activity;
}
