public class Sierpinski {

    public static double height(double length) {
        return (length / 2) * Math.sqrt(3);
    }

    public static void filledTriangle(double x, double y, double length) {
        double[] x_os = new double[3]; // os --> х / y оси
        double[] y_os = new double[3];
        x_os[0] = x;
        y_os[0] = y;
        x_os[1] = x + length / 2;
        x_os[2] = x - length / 2;
        y_os[1] = y + height(length);
        y_os[2] = y + height(length);
        StdDraw.filledPolygon(x_os, y_os);
    }

    public static void sierp(int n, double x, double y, double length) {
        filledTriangle(x, y, length);
        if (n > 1) {
            sierp(n - 1, x + length / 2, y, length / 2);
            sierp(n - 1, x - length / 2, y, length / 2);
            sierp(n - 1, x, y + height(length), length / 2);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x_cor = new double[3];
        double[] y_cor = new double[3];
        x_cor[0] = 0;
        y_cor[0] = 0;
        x_cor[1] = 1;
        y_cor[1] = 0;
        x_cor[2] = 0.5;
        y_cor[2] = Math.sqrt(3) / 2;
        StdDraw.polygon(x_cor, y_cor);
        sierp(n, 0.5, 0, 0.5);
    }
}
