package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton") // можно не писать, тк он по умолчанию
public class Dog implements Pet {
    private String name;

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

//    @PostConstruct
//    protected void init() {
//        System.out.println("Class Dog: init method");
//    }
//
//    @PreDestroy
//    private void destroy() {
//        System.out.println("Class Dog: destroy method");
//    }

}
