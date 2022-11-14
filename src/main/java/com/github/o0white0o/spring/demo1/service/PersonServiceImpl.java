package com.github.o0white0o.spring.demo1.service;

import com.github.o0white0o.spring.demo1.dao.IPersonDao;
import com.github.o0white0o.spring.demo1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements IPersonService{

private final IPersonDao personDao;

@Autowired
public PersonServiceImpl(IPersonDao personDao) {
    this.personDao = personDao;
}

@Override
public Person getByName(String name) {
    return personDao.findByName(name);
}

}
