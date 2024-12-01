package problem_four;

public record Circle(double radius) {
    public Circle {
        if (radius <= 0){
            throw new IllegalArgumentException("Radius should be positive value");
        }
    }
    public double computeArea(){
        return Math.PI * radius * radius;
    }
}
