package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        double surfaceArea;
        surfaceArea = (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
        return surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        double surfaceArea;
        surfaceArea = (2 * this.length * this.height) + (2 * this.width * this.height);
        return surfaceArea;
    }

    public double calculateVolume() {
        double volume;
        volume = length * width * height;
        return volume;
    }
}
