package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// context без xml - спопоб первый !!!
public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

    }
}
