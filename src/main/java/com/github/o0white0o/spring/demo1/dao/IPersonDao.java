package com.github.o0white0o.spring.demo1.dao;

import com.github.o0white0o.spring.demo1.domain.Person;

public interface IPersonDao {

Person findByName(String name);
}
