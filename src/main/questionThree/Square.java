package main.questionThree;

public class Square implements Shape{
    private double side;
    @Override
    public double area() {
        return Math.pow(side, 2);
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
