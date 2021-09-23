public class Transform2D {

    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    public static double[] copy(double[] array) {
        double[] copied_array = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copied_array[i] = array[i];
        }
        return copied_array;
    }

    public static void rotate(double[] x, double[] y, double theta) {
        for (int i = 0; i < x.length; i++) {
            double temp_x = x[i];
            double temp_y = y[i];
            x[i] = temp_x * Math.cos(Math.toRadians(theta)) - temp_y * Math
                    .sin(Math.toRadians(theta));
            y[i] = temp_y * Math.cos(Math.toRadians(theta)) + temp_x * Math
                    .sin(Math.toRadians(theta));
        }
    }

    public static void main(String[] args) {

    }
}
