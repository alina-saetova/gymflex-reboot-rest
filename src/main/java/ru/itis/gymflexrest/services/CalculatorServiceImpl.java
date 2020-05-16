package ru.itis.gymflexrest.services;

import org.springframework.stereotype.Service;
import ru.itis.gymflexrest.dto.CalculatorDto;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private TreeMap<String, Double> act;

    @PostConstruct
    public void init() {
        act = new TreeMap<>();
        act.put("none", 1.2);
        act.put("small", 1.375);
        act.put("medium", 1.55);
        act.put("big", 1.725);
        act.put("huge", 1.9);
    }

    @Override
    public Long calculate(CalculatorDto dto) {
        long result;
        if (dto.getGender().equals("female")) {
            if (dto.getFormula().equals("harris")) {
                result = Math.round((447.593 + 9.247 * dto.getWeight()
                        + 3.098 * dto.getHeight()
                        - 4.33 * dto.getAge())
                        * act.get(dto.getActivity()));
            } else {
                result = Math.round((10 * dto.getWeight()
                        + 6.25 * dto.getHeight()
                        - 5 * dto.getAge()
                        - 161)
                        * act.get(dto.getActivity()));
            }
        } else {
            if (dto.getFormula().equals("harris")) {
                result = Math.round((float) (88.362 + 13.397 * dto.getWeight()
                        + 4.799 * dto.getHeight()
                        - 5.677 * dto.getAge())
                        * act.get(dto.getActivity()));
            } else {
                result = Math.round((10 * dto.getWeight()
                        + 6.25 * dto.getHeight()
                        - 5 * dto.getAge()
                        + 5)
                        * act.get(dto.getActivity()));
            }
        }
        return result;
    }
}
