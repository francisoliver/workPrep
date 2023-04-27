package Practice;

public class StaticVariableSample {
    static int count = 0;
    public void increment() {
        count++;
    }

    public static void main(String[] args) {
        StaticVariableSample staticVariableSample1 = new StaticVariableSample();
        StaticVariableSample staticVariableSample2 = new StaticVariableSample();

        staticVariableSample1.increment();
        staticVariableSample2.increment();

        System.out.println("object 1 count is " + staticVariableSample1.count);
        System.out.println("object 2 count is " + staticVariableSample1.count);
        staticVariableSample1.increment();
        System.out.println("object 1 count after is " + staticVariableSample1.count);
        staticVariableSample2.increment();
        System.out.println("object 2 count after is " + staticVariableSample1.count);

    }
}
