import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<DataPoint> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s30205\\Desktop\\Perceptron\\src\\iris.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] tokens = line.split(",");
                if (tokens.length != 5)
                    continue;
                double[] features = new double[4];
                for (int i = 0; i < 4; i++) {
                    features[i] = Double.parseDouble(tokens[i]);
                }
                int label = tokens[4].trim().equalsIgnoreCase("Iris-setosa") ? 1 : 0;
                data.add(new DataPoint(label, features));
            }
        } catch (IOException e) {
            System.err.println("Błąd wczytywania pliku: " + e.getMessage());
            return;
        }

        Collections.shuffle(data, new Random(42));

        // Podział na zbiór uczący (70%) i testowy (30%)
        int trainSize = (int) (data.size() * 0.7);
        List<DataPoint> trainSet = data.subList(0, trainSize);
        List<DataPoint> testSet = data.subList(trainSize, data.size());

        Perceptron perceptron = new Perceptron(4, 1, 0.1);

        // Trening perceptronu
        int maxEpochs = 100;
        for (int epoch = 0; epoch < maxEpochs; epoch++) {
            int errors = 0;
            for (DataPoint dp : trainSet) {
                if (perceptron.compute(dp.features) != dp.label) {
                    perceptron.learn(dp.features, dp.label);
                    errors++;
                }
            }
            if (errors == 0) {
                System.out.println("Trening zakończony po " + (epoch + 1) + " epokach.");
                break;
            }
        }

        // Testowanie perceptronu
        int correct = 0;
        for (DataPoint dp : testSet) {
            int prediction = perceptron.compute(dp.features);
            if (prediction == dp.label) {
                correct++;
            }
        }
        double accuracy = (double) correct / testSet.size();
        System.out.printf("(Iris-setosa vs. reszta): %.2f%%\n", accuracy * 100);
    }
}
