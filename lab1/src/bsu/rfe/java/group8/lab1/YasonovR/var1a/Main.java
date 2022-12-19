package bsu.rfe.java.group8.lab1.YasonovR.var1a;

//import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        int CheeseCount = 0, AppleCount = 0, TeaCount = 0;
        Cheese Ch = new Cheese();
        Tea t = new Tea(null);
        Apple Ap = new Apple(null);
        Grusha g = new Grusha();
        g.consume();
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
            }
            if (parts[0].equals("Tea")) {
                breakfast[itemsSoFar] = new Tea(parts[1]);
            }

            itemsSoFar++;
        }
        System.out.println("Counter of  all products");
        for (int i = 0; i < 20; i++) {
            if (breakfast[i] != null) {
                if (breakfast[i].equals(Ch)) {
                    CheeseCount++;
                } else if (breakfast[i].equals(Ap)) {
                    AppleCount++;
                } else if (breakfast[i].equals(t)) {
                    TeaCount++;
                }
            } else break;
        }
        System.out.println("Counter of apples is " + AppleCount + ", Counter of cheese is " + CheeseCount + ", Counter of cup of tea is " + TeaCount + "");
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else break;
        }
        System.out.println("Хорошего дня!");
    }
}