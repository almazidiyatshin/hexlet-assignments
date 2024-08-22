package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    public int compareTo(Home anotherCottage) {
        if (area == anotherCottage.getArea()) {
            return 0;
        }

        return area > anotherCottage.getArea() ? 1 : -1;
    }
}
// END
