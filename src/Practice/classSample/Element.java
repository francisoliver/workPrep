package Practice.classSample;

import java.util.ArrayList;
import java.util.List;

public class Element {
    String name;
    String symbol;
    double weight;
    int group;
    int period;
    Element(String name, String symbol, double weight, int group, int period) {
        this.name = name;
        this.symbol = symbol;
        this.weight = weight;
        this.group = group;
        this.period = period;
        elements.add(this);
    }

    static List<Element> elements = new ArrayList<Element>();

    public String getSymbol() {
        return symbol;//
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getPeriod() {
        return period;
    }

    public int getGroup() {
        return group;
    }

    static double getTotalWeight() {
        double result = 0;
        for (Element e:elements) {
            result+= e.weight;
        }
        return result;
    }

    static int countTotalElements() {
        return elements.size();
    }
}
