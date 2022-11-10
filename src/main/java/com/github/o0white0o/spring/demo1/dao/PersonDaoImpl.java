package com.github.o0white0o.spring.demo1.dao;

import com.github.o0white0o.spring.demo1.domain.Person;

public class PersonDaoImpl implements IPersonDao {

private int defaultAge;
@Override
public Person findByName(String name) {
    if(name.equals("Aleksei")) {
        return new Person(name, 26);
    }
    return new Person(name, defaultAge);
}

public void setDefaultAge(int defaultAge){
    this.defaultAge = defaultAge;
}

}
