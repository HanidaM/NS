import java.util.Arrays;

public class MultiPerceptron {
    private int m;
    private int n;
    private Perceptron[] percept;


    // Creates a multi-perceptron with m classes and n inputs.
    public MultiPerceptron(int m, int n) {
        this.m = m;
        this.n = n;
        percept = new Perceptron[m];
        for (int i = 0; i < percept.length; i++) {
            percept[i] = new Perceptron(n);
        }

    }

    // Returns the number of classes m.
    public int numberOfClasses() {
        return m;
    }

    // Returns the number of inputs n.
    public int numberOfInputs() {
        return n;
    }

    // Returns the predicted label for the given input.
    public int predictMulti(double[] x) {
        double[] weight = new double[percept.length];
        double mx = 0;
        int indx = 0;

        for (int i = 0; i < percept.length; i++) {
            weight[i] = percept[i].weightedSum(x);
            if (weight[i] > mx) {
                mx = weight[i];
                indx = i;
            }
        }
        return indx;

    }


    // Trains this multi-perceptron on the labeled input.
    public void trainMulti(double[] x, int label) {
        for (int i = 0; i < percept.length; i++) {
            if (label == i)
                percept[i].train(x, +1);
            else
                percept[i].train(x, -1);
        }
    }

    // Returns a string representation of this multi-perceptron.
    public String toString() {
        return Arrays.toString(percept);
    }

    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        int m = 2;
        int n = 3;

        double[] training1 = { 5.0, -4.0, 3.0 };
        double[] training2 = { 2.0, 3.0, -2.0 };
        double[] training3 = { 4.0, 3.0, 2.0 };
        double[] training4 = { -6.0, -5.0, 7.0 };

        MultiPerceptron perceptron = new MultiPerceptron(m, n);
        StdOut.println(perceptron);
        perceptron.trainMulti(training1, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training2, 0);
        StdOut.println(perceptron);
        perceptron.trainMulti(training3, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training4, 0);
        StdOut.println(perceptron);

    }

}
