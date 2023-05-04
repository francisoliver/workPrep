package Practice.classSample;

public class Dog {

    String name;
    int age;
    String color;
    DogBreed breed;

    public Dog(String name, int age, String color, DogBreed breed) {

        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;

    }

    public String toString() {
        return "\nHi my name is " + name + ". I'am " + age + " years old. \n " +breed.getDescription();
    }

}
