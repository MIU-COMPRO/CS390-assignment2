package problem_four;

final public class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double width, double length){

        if(width <= 0.0 || length <= 0.0 ){
            throw new IllegalArgumentException("width and radius should be positive values");
        }
        this.length = length;
        this.width = width;
    }

    public double computeArea(){
        return length*width;
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }
}
