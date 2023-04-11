public class Person {
    private String name;
    private String food;
    private int age;
    Person(String name, int age, String food) {
        this.name = name;
        this. age = age;
        this.food = food;
    }

    @Override
    public String toString() {
        return name;
    }

    public void print() {

        System.out.println("Hi, my name is: "+ this.name);
        System.out.println(this.age + " years old");
        System.out.println("My favorite food is/are: "+ this.food);
        System.out.println("Goodbye, see you next time");

    }

}
