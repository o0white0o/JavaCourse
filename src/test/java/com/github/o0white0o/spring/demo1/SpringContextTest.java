package com.github.o0white0o.spring.demo1;

import com.github.o0white0o.spring.demo1.service.IPersonService;
import com.github.o0white0o.spring.demo1.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextTest {

private ClassPathXmlApplicationContext context;

@Test
public void contextWithConstructorRefTest() {

    context = new ClassPathXmlApplicationContext(
            "spring/demo1/spring-context.xml");

    IPersonService personService = context.getBean(PersonServiceImpl.class);
    Assertions.assertEquals("Person{name='Aleksei', age=26}",
                            personService.getByName("Aleksei").toString(),
                            "Error");
}

@Test
public void contextWithPropertyRefTest() {

    context = new ClassPathXmlApplicationContext(
            "spring/demo1/spring-contextProp.xml");

    IPersonService personService = context.getBean(PersonServiceImpl.class);
    Assertions.assertEquals("Person{name='Alex', age=27}",
                            personService.getByName("Alex").toString(),
                            "Error");
}

}
