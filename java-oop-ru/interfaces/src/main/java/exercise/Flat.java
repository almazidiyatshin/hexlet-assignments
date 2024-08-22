package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area + balconyArea;
        this.floor = floor;
    }

    public String toString() {
        return "Квартира площадью " + area + " метров на " + floor + " этаже"
    }

    public double getArea() {
        return area;
    }

    public int compareTo(Home anotherHome) {
        if (area == anotherHome.getArea()) {
            return 0;
        }

        return area > anotherHome.getArea() ? 1 : -1;
    }
}
// END
