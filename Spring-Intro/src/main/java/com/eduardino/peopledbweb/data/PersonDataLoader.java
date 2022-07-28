package com.eduardino.peopledbweb.data;

import com.eduardino.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
            new Person(null,"Pete","Snake", LocalDate.of(1950, 1,1), new BigDecimal("100")),
            new Person(null,"Jennifer","Smith", LocalDate.of(1960, 2,1), new BigDecimal("100")),
            new Person(null,"Mark","Jackson", LocalDate.of(1970, 3,1), new BigDecimal("100")),
            new Person(null,"Vishnu","McGuire", LocalDate.of(19997, 4,1), new BigDecimal("100")),
            new Person(null,"Alice","Jane", LocalDate.of(1970, 5,1), new BigDecimal("100")),
            new Person(null,"Akira","Kim", LocalDate.of(1980, 6,1), new BigDecimal("100"))
            );
            personRepository.saveAll(people);
        }
    }
}
