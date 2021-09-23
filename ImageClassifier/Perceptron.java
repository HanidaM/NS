import java.util.Arrays;

public class Perceptron {
    public int n;
    public double[] w;


    // Creates a perceptron with n inputs.
    public Perceptron(int n) {
        this.n = n;
        w = new double[n];
    }

    // Returns the number of inputs n.
    public int numberOfInputs() {
        return n;
    }

    // Returns the weighted sum of the weight vector and x.
    public double weightedSum(double[] x) {
        double wesum = 0;
        for (int i = 0; i < x.length; i++) {
            wesum += x[i] * w[i];

        }
        return wesum;
    }

    // Predict the label of input x (+1 or -1).
    public int predict(double[] x) {
        if (weightedSum(x) > 0)
            return +1;
        else
            return -1;

    }

    // Trains this perceptron on the labeled (+1 or -1) input x.
    public void train(double[] x, int label) {
        if (predict(x) != label && predict(x) > 0)
            for (int i = 0; i < x.length; i++) {
                w[i] -= x[i];
            }
        if (predict(x) != label && predict(x) <= 0)
            for (int i = 0; i < x.length; i++) {
                w[i] += x[i];

                // for (int i = 0; i < x.length; i++) {
                //     if (label > 0 && label != predict(x))
                //         w[i] += x[i];
                //     else if (label < 0 && label != predict(x))
                //         w[i] -= x[i];
            }

    }

    // Returns a string representation of this perceptron.
    public String toString() {
        return Arrays.toString(w);

    }

    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {

        double[] training1 = { 5.0, -4.0, 3.0 };  // yes
        double[] training2 = { 2.0, 3.0, -2.0 };  // no
        double[] training3 = { 4.0, 3.0, 2.0 };  // yes
        double[] training4 = { -6.0, -5.0, 7.0 };  // no

        int n = 3;
        Perceptron perceptron = new Perceptron(n);
        StdOut.println(perceptron);
        perceptron.train(training1, +1);
        StdOut.println(perceptron);
        perceptron.train(training2, -1);
        StdOut.println(perceptron);
        perceptron.train(training3, +1);
        StdOut.println(perceptron);
        perceptron.train(training4, -1);
        StdOut.println(perceptron);


    }

}
