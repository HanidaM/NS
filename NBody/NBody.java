public class NBody {

    public static final double G = 6.67e-11;


    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double force(double m1, double m2, double r) {
        return G * (m1 * m2) / (r * r);
    }

    public static void main(String[] args) {

        double T = 0;
        double dt = 0;

        if (args.length != 2) {
            return;
        }
        else {
            T = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
        }

        int n = StdIn.readInt();
        double R = StdIn.readDouble();

        double px[] = new double[n];
        double py[] = new double[n];
        double vx[] = new double[n];
        double vy[] = new double[n];
        double m[] = new double[n];

        String image[] = new String[n];

        for (int i = 0; i < n; ++i) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            m[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        StdDraw.setScale(-R, R);
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(0, 0, "starfield.jpg");
        StdAudio.play("2001.wav");

        for (double t = 0; t <= T; t += dt) {

            double fx[] = new double[n];
            double fy[] = new double[n];

            for (int i = 0; i < n; ++i) {
                fx[i] = 0;
                fy[i] = 0;

                for (int j = 0; j < n; ++j) {
                    if (j == i) continue;

                    double r = distance(px[i], py[i], px[j], py[j]);
                    double f = force(m[i], m[j], r);

                    fx[i] += f * ((px[j] - px[i]) / r);
                    fy[i] += f * ((py[j] - py[i]) / r);
                }
            }

            double ax[] = new double[n];
            double ay[] = new double[n];

            for (int i = 0; i < n; ++i) {
                ax[i] = fx[i] / m[i];
                ay[i] = fy[i] / m[i];
            }

            for (int i = 0; i < n; ++i) {
                vx[i] += dt * ax[i];
                vy[i] += dt * ay[i];
            }

            for (int i = 0; i < n; ++i) {
                px[i] += dt * vx[i];
                py[i] += dt * vy[i];
            }

            StdDraw.picture(0, 0, "starfield.jpg");
            for (int i = 0; i < n; ++i) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }

        StdOut.println(n);
        StdOut.println(R);
        for (int i = 0; i < n; ++i) {
            StdOut.printf("%14.5e %14.5e %14.5e %14.5e %14.5e %14s\n",
                          px[i], py[i], vx[i], vy[i], m[i], image[i]);
        }
    }

}
