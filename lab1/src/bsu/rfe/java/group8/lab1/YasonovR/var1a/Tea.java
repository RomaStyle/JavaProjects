package bsu.rfe.java.group8.lab1.YasonovR.var1a;

public class Tea extends Food {

    private String color;
    public Tea (String color)
    {
        super("Tea");
        this.color = color;
    }
    public void consume() {
        System.out.println(this + "выпит");
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return super.toString() + " color '" +  color.toUpperCase() + "'";
    }

}