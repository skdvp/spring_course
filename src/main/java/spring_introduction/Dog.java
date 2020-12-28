package spring_introduction;

public class Dog implements Pet{
    private String name;

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-wow");
    }
}
