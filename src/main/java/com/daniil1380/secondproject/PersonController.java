package com.daniil1380.secondproject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private final List<Person> people;

    public PersonController() {
        people = new ArrayList<>();
        people.add(new Person(UUID.randomUUID(), "Даниил"));
        people.add(new Person(UUID.randomUUID(), "Андрей"));
        people.add(new Person(UUID.randomUUID(), "Ирина"));
        people.add(new Person(UUID.randomUUID(), "Лариса"));
        people.add(new Person(UUID.randomUUID(), "Виктория"));
        people.add(new Person(UUID.randomUUID(), "Александр"));
        people.add(new Person(UUID.randomUUID(), "Олександр"));
        people.add(new Person(UUID.randomUUID(), "Андрей"));
    }

    @GetMapping(value = "/person")
    public List<Person> getPerson() {
        return people;
    }

    @GetMapping(value = "/person/{id}")
    public Person getPersonFromId(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        return people.get(idNumber);
    }

    @PostMapping(value = "/person")
    public Person addPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }

    //@RequestBody - 1 (чаще всего в post запросах, когда передаем большой тяжелый объект)
    //@PathVariable - 2 (переменная пути, если видим {} - это оно)
    //@RequestParam - 3 (параметр запроса, чаще всего очень простое значение, выбираем, если
    //не 1, и не 2

    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        people.remove(idNumber);
    }

}
































//@GetMapping(value = "/hello")
//public String hello() {
//    return "Привет мир";
//}
//
//@GetMapping(value = "/hello/{a}")
//public String helloWorld(@PathVariable String a) {
//    return "Привет мир " + a;
//}
//
//@GetMapping(value = "/sum")
//public String sum(@RequestParam String first, @RequestParam String second) {
//    return first + second;
//}
