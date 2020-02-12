package logic;

public class Vector2 {

    public static final Vector2 zero = new Vector2(0, 0);
    public static final Vector2 ones = new Vector2(1, 1);

    private double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {}

    public void setValues(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void normalize() {
        double len = getLength();
        if (len == 0) { return; }

        double factor = 1/len;
        this.x = x*factor;
        this.y = y*factor;
    }

    public Vector2 getNormalized() {
        Vector2 newV = new Vector2(this.x, this.y);
        newV.normalize();
        return newV;
    }

    public double getLength() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(this.x + v.getX(), this.y + v.getY());
    }

    public Vector2 subtract(Vector2 v) { return new Vector2(this.x - v.getX(), this.y - v.getY()); }

    public Vector2 scalarMult(double a) {
        return new Vector2(a*this.getX(), a*this.getY());
    }

    public Vector2 rotateVec(double alpha) {
        double newX = Math.cos(alpha) * this.getX() - Math.sin(alpha) * this.getY();
        double newY = Math.sin(alpha) * this.getX() - Math.cos(alpha) * this.getY();
        return new Vector2(newX, newY);
    }

    public double getDistance(Vector2 other) {
        return Math.sqrt( Math.pow(other.getX() - x, 2) + Math.pow(other.getY() - y, 2));
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public void print() {
        System.out.println("(" + this.getX() + " | " + this.getY() + ")" + "    Length: " + this.getLength());
    }

}