package com.example.hiber;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoRepo extends JpaRepository<Persons, Persons.PersonsPK> {

    @Query("select p from Persons p where p.cityOfLiving = :city")
    List<Persons> getByCityOfLiving(String city);

    @Query("select p from Persons p where p.personsPK.age < :age order by p.personsPK.age")
    List<Persons> findByPersonsPKAgeLessThanOrderByPersonsPKAge(int age);

    @Query("select p from Persons p where p.personsPK.name = :name and p.personsPK.surname = :surname")
    Optional<Persons> getPersonsByPersonsPKNameAndAndPersonsPKSurname(String name, String surname);

}
