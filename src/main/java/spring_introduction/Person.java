package spring_introduction;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    //    @Value("Tregulov") //Hardcoded
    @Value("${person.surname}") //ok <context:property-placeholder location="myApp.properties"/>
    private String surname;
    //    @Value("33") //Hardcoded
    @Value("${person.age}") //ok <context:property-placeholder location="myApp.properties"/>
    private String age;

    public Person(@Qualifier("dog") Pet pet) { // перед параметром
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
