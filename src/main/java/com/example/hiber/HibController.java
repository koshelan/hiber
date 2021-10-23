package com.example.hiber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class HibController {

    private DaoRepo repository;

    public HibController(DaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }

    @GetMapping("/")
    public String preparation() {
        repository.prepare(new Persons(
                "ilya", "Li", 35, "77777777", "Ryazan"));
        repository.prepare(new Persons(
                "Petr", "Petrov", 28, "333333333", "Tula"));
        repository.prepare(new Persons(
                "Stepan", "stepanov", 77, "1111", "moscow"));
        return "ok";
    }
}
