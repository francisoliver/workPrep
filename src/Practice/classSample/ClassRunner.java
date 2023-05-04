package Practice.classSample;

import java.util.ArrayList;
import java.util.List;

public class ClassRunner {
    public static void main(String[] args) {

        Dog bantay = new Dog("Bantay", 3, "black", DogBreed.GERMAN_SHEPHERD);
        Dog wolfy = new Dog("wolfy", 2, "white", DogBreed.SIBERIAN_HUSKY);
        Dog nep = new Dog("Nep", 1, "white", DogBreed.BULLDOG);
        Dog larry = new Dog("Larry", 5, "black", DogBreed.LABRADOR_RETRIEVER);

        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(bantay);
        dogs.add(wolfy);
        dogs.add(nep);
        dogs.add(larry);

        for(Dog d: dogs) {
            System.out.println(d.toString());
        }

    }
}
