public class Art {

    private static void draw(double x, double y, double length) {
        double[] x_os = new double[6]; //os - x / y оси
        double[] y_os = new double[6];
        x_os[0] = x + length;
        y_os[0] = y;
        x_os[1] = x - length;
        y_os[1] = y;
        x_os[2] = x + length / 2;
        y_os[2] = y + (length / 2) * Math.sqrt(3);
        x_os[3] = x + length / 2;
        y_os[3] = y - (length / 2) * Math.sqrt(3);
        x_os[4] = x - length / 2;
        y_os[4] = y + (length / 2) * Math.sqrt(3);
        x_os[5] = x - length / 2;
        y_os[5] = y - (length / 2) * Math.sqrt(3);

        for (int i = 0; i < 6; i++) {
            StdDraw.line(x, y, x_os[i], y_os[i]);
        }

    }

    private static void snow(int n, double x, double y, double length) {
        draw(x, y, length);
        if (n > 1) {
            snow(n - 1, x + length, y, length / 3);
            snow(n - 1, x - length, y, length / 3);
            snow(n - 1, x + length / 2, y + (length / 2) * Math.sqrt(4), length / 3);
            snow(n - 1, x + length / 2, y - (length / 2) * Math.sqrt(4), length / 3);
            snow(n - 1, x - length / 2, y + (length / 2) * Math.sqrt(4), length / 3);
            snow(n - 1, x - length / 2, y - (length / 2) * Math.sqrt(4), length / 3);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        snow(n, 0.5, 0.5, 0.125);
    }
}
