import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class KNN {

    private final int k;
    private final TreeMap<String, TreeMap<String, ArrayList<double[]>>> data = new TreeMap<>();

    public KNN(Path path, int k) {
        this.k = k;
        data.put("learning", new TreeMap<>());
        data.put("test", new TreeMap<>());
        sortData(path.toString());
        double euclideanAccuracy = test(data.get("test"), data.get("learning"), "euclidean");
        double manhattanAccuracy = test(data.get("test"), data.get("learning"), "manhattan");
        System.out.println("Euclidean accuracy: " + euclideanAccuracy + "%");
        System.out.println("Manhattan accuracy: " + manhattanAccuracy + "%");
    }

    private void sortData(String path) {
        TreeMap<String, Integer> trainingCounts = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String label = parts[parts.length - 1].trim();

                double[] features = new double[parts.length - 1];
                for (int i = 0; i < parts.length - 1; i++) {
                    features[i] = Double.parseDouble(parts[i]);
                }

                if (!data.get("learning").containsKey(label)) {
                    data.get("learning").put(label, new ArrayList<>());
                }
                if (!data.get("test").containsKey(label)) {
                    data.get("test").put(label, new ArrayList<>());
                }

                int count = trainingCounts.getOrDefault(label, 0);
                if (count < 40) {
                    data.get("learning").get(label).add(features);
                    trainingCounts.put(label, count + 1);
                } else {
                    data.get("test").get(label).add(features);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private double euclideanDistance(double[] a, double[] b){
        double sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }

    private double manhattanDistance(double[] a, double[] b){
        double sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    private double test(TreeMap<String, ArrayList<double[]>> testSet, TreeMap<String, ArrayList<double[]>> learningSet, String distanceType){
        int correct = 0;
        int total = 0;
        for(String label : testSet.keySet()) {
            for (double[] test : testSet.get(label)) {
                TreeMap<Double, String> distances = new TreeMap<>();
                for (String learningLabel : learningSet.keySet()) {
                    for (double[] learning : learningSet.get(learningLabel)) {
                        double distance = distanceType.equals("euclidean") ? euclideanDistance(test, learning) : manhattanDistance(test, learning);
                        distances.put(distance, learningLabel);
                    }
                }

                int cnt = 0;
                TreeMap<String, Integer> voteMap = new TreeMap<>();
                for (Double distance : distances.keySet()) {
                    if (cnt >= this.k) break;
                    String neighborLabel = distances.get(distance);
                    voteMap.put(neighborLabel, voteMap.getOrDefault(neighborLabel, 0) + 1);
                    cnt++;
                }

                String predictedLabel = null;
                int maxVotes = -1;
                for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
                    if (entry.getValue() > maxVotes) {
                        maxVotes = entry.getValue();
                        predictedLabel = entry.getKey();
                    }
                }

                if (predictedLabel != null && predictedLabel.equals(label)) {
                    correct++;
                }
                total++;
            }
        }

        return (total > 0) ? (100.0 * correct / total) : 0.0;
    }
}
