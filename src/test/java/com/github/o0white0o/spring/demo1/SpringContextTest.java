package com.github.o0white0o.spring.demo1;

import com.github.o0white0o.spring.demo1.service.IPersonService;
import com.github.o0white0o.spring.demo1.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextTest {

private AnnotationConfigApplicationContext context;

@BeforeEach
public void setUp() {
    context = new AnnotationConfigApplicationContext(AppConfig.class);
}

@Test
public void contextTest() {

    IPersonService personService = context.getBean("personService", PersonServiceImpl.class);
    Assertions.assertEquals("Person{name='Alex', age=26}",
                            personService.getByName("Alex").toString(),
                            "Error");
}

}
