package ru.itis.gymflexrest.services;

import ru.itis.gymflexrest.dto.CalculatorDto;

public interface CalculatorService {

    Long calculate(CalculatorDto dto);
}
