package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private String surname;
    private String age;

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

    @Autowired // с 4.3 : имеется всего один конструктор, то можно не писать
    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
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
