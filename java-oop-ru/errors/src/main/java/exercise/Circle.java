package exercise;

// BEGIN
class Circle {
    private Point point;
    private int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public int getSquare() throws NegativeRadiusException {
        var square = Math.PI * Math.pow(radius, 2);

        if (square < 0) {
            throw NegativeRadiusException();
        }

        return square;
    }
}
// END
