package com.example.hiber;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@Entity
public class Persons {
    @EmbeddedId
    private PersonsPK personsPK;
    private String phoneNumber;
    private String cityOfLiving;

    public Persons(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        this.personsPK = new PersonsPK(name,surname,age);
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public Persons(PersonsPK personsPK, String phoneNumber, String cityOfLiving) {
        this.personsPK = personsPK;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public Persons() {
    }

    @Data
@Builder
    @Embeddable
    public static class PersonsPK implements Serializable {

        String name;
        String surname;
        int age;

        public PersonsPK(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public PersonsPK() {
        }
    }
}
