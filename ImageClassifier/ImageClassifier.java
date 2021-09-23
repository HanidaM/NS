import java.awt.Color;

public class ImageClassifier {

    // Creates a feature vector (1D array) from the given picture.
    public static double[] extractFeatures(Picture pic) { //moi fEaTuRe
        int w = pic.width();
        int h = pic.height();
        int GG;
        int n = w * h;
        double[] length = new double[n];
        int arr = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color color = pic.get(i, j);
                GG = color.getGreen();
                length[arr] = GG;
                arr++;
            }
        }
        return length;
    }

    // See below.
    public static void main(String[] args) {
        In train = new In(args[0]);
        int m = train.readInt();
        int w = train.readInt();
        int h = train.readInt();
        int n = w * h;

        //Training process
        MultiPerceptron classifier = new MultiPerceptron(m, n);
        while (!train.isEmpty()) {
            String file = train.readString();
            int label = train.readInt();
            Picture pic = new Picture(file);
            classifier.trainMulti(extractFeatures(pic), label);

        }


        //Testing >>> URAAAAA

        In testing = new In(args[1]);
        m = testing.readInt();
        w = testing.readInt();
        h = testing.readInt();
        int error = 0;
        int total = 0;
        while (!testing.isEmpty()) {
            String files = testing.readString();
            int label = testing.readInt();
            Picture image = new Picture(files);
            int predict = classifier.predictMulti(extractFeatures(image));
            if (predict != label) {
                System.out.println(files);
                error++;
            }
            total++;
        }
        System.out.println("Test errors = " + ((double) error / total));
    }

}
