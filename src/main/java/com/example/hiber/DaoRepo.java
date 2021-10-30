package com.example.hiber;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoRepo extends JpaRepository<Persons, Persons.PersonsPK> {

    List<Persons> getPersonsByCityOfLiving(String city);

    List<Persons> findByPersonsPKAgeLessThanOrderByPersonsPKAge(int age);

    Optional<Persons> getPersonsByPersonsPKNameAndAndPersonsPKSurname(String name, String surname);



}
