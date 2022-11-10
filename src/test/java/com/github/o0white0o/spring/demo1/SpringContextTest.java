package com.github.o0white0o.spring.demo1;

import com.github.o0white0o.spring.demo1.service.IPersonService;
import com.github.o0white0o.spring.demo1.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextTest {

private ClassPathXmlApplicationContext context;

@BeforeEach
public void setUp() {
    context = new ClassPathXmlApplicationContext(
            "spring/demo1/spring-context.xml");
}

@Test
public void contextWithConstructorRefTest() {

    IPersonService personService = context.getBean("personService", PersonServiceImpl.class);
    Assertions.assertEquals("Person{name='Aleksei', age=26}",
                            personService.getByName("Aleksei").toString(),
                            "Error");
}

@Test
public void contextWithPropertyRefTest() {
    IPersonService personService = context.getBean("personServiceWithProp", PersonServiceImpl.class);
    Assertions.assertEquals("Person{name='Alex', age=27}",
                            personService.getByName("Alex").toString(),
                            "Error");
}

}
