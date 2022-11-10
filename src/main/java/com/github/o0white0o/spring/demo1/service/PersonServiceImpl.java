package com.github.o0white0o.spring.demo1.service;

import com.github.o0white0o.spring.demo1.dao.IPersonDao;
import com.github.o0white0o.spring.demo1.domain.Person;

public class PersonServiceImpl implements IPersonService{

private IPersonDao personDao;

public PersonServiceImpl() {}

public PersonServiceImpl(IPersonDao personDao) {
    this.personDao = personDao;
}

@Override
public Person getByName(String name) {
    return personDao.findByName(name);
}

public void setPersonDao(IPersonDao personDao) {
    this.personDao = personDao;
}

}
