package se.joel.math3d;

/**
 * A 4D Vector.
 */
public class Vector4D {
    private double x;
    private double y;
    private double z;
    private double w;

    public Vector4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4D(double x, double y, double z) {
        this(x, y, z, 1);
    }

    public Vector4D(double x, double y) {
        this(x, y, 0, 1);
    }

    public Vector4D normalize() {
        double m = magnitude();
        x /= m;
        y /= m;
        z /= m;
        return this;
    }

    public Vector4D copy() {
        return new Vector4D(x, y, z, w);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double dot(Vector4D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector4D cross(Vector4D other) {
        return new Vector4D(
                this.y * other.z - this.z * other.y,
                other.x * this.z - other.z * this.x,
                this.x * other.y - this.y * other.x);
    }

    public Vector4D scale(double scale) {
        return new Vector4D(x * scale, y * scale, z * scale);
    }

    public Vector4D projectOn(Vector4D other) {
        Vector4D normOther = other.copy().normalize();
        return normOther.scale(this.dot(normOther));
    }

    public double[] asArray() {
        return new double[]{x, y, z, w};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector4D vector4D = (Vector4D) o;

        if (Double.compare(vector4D.w, w) != 0) return false;
        if (Double.compare(vector4D.x, x) != 0) return false;
        if (Double.compare(vector4D.y, y) != 0) return false;
        if (Double.compare(vector4D.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = z != +0.0d ? Double.doubleToLongBits(z) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = w != +0.0d ? Double.doubleToLongBits(w) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[ " + x + " " + y + " " + z + " " + w + " ]";
    }
}
