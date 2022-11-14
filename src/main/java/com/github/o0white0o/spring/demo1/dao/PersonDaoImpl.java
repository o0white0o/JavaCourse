package com.github.o0white0o.spring.demo1.dao;

import com.github.o0white0o.spring.demo1.domain.Person;
import org.springframework.stereotype.Component;

@Component("personDao")
public class PersonDaoImpl implements IPersonDao {

@Override
public Person findByName(String name) {
        return new Person(name, 26);
}

}
