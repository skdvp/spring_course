package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

// способ  2 без xml : не используется @Configuration и @ComponentScan
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean(){ // Bean - это назв. метода
        return new Cat();
    }
    // если @Scope("singleton") - то return new Cat() сработает 1 раз!


    @Bean
    public  Person personBean(){
        return new Person(catBean());
    }
}
