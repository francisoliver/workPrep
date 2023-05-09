package Practice.classSample;

public class ElementMain {
    public static void main(String[] args) {

        Element hydrogen = new Element("Hydrogen", "H", 1.008, 1, 1);
        Element helium = new Element("Helium", "He", 4.0026, 1, 18);
        Element lithium = new Element("Lithium", "Li", 6.94, 2, 1);
        Element beryllium = new Element("Beryllium", "Be", 9.0122, 2, 2);
        System.out.printf("Total weight of elements are: %f\n", Element.getTotalWeight());
        System.out.printf("There are %d of elements \n", Element.countTotalElements());
        System.out.printf("Average weight is %f of elements \n", Element.getTotalWeight() / Element.countTotalElements());

    }
}
