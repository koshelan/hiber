package com.example.hiber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class HibController {

    private DaoRepo repository;

    public HibController(DaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCityOfLiving(city);
    }

    @GetMapping("/age")
    public List<Persons> getPersonsByCity(@RequestParam int age) {
        return repository.findByPersonsPKAgeLessThanOrderByPersonsPKAge(age);
    }

    @GetMapping("/name")
    public Optional<Persons> getPersonsByCity(@RequestParam String name, @RequestParam String surname) {
        return repository.getPersonsByPersonsPKNameAndAndPersonsPKSurname(name,surname);
    }

    @GetMapping("/")
    public String preparation() {
        repository.save(new Persons(
                "ilya", "Li", 35, "77777777", "Ryazan"));
        repository.save(new Persons(
                "Petr", "Petrov", 28, "333333333", "Tula"));
        repository.save(new Persons(
                "Stepan", "stepanov", 77, "1111", "moscow"));
        return "ok";
    }
}
