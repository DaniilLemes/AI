# K-Nearest Neighbors (KNN) in Java

This repository contains a simple implementation of the K-Nearest Neighbors (KNN) algorithm in Java. It is designed as an educational tool to help you understand how KNN works, using a real-world dataset (the Iris dataset) as an example.

## What is K-Nearest Neighbors (KNN)?

KNN is a **lazy learning** algorithm used for both classification and regression. Here are the core ideas behind KNN:

- **Instance-Based Learning:**  
  Instead of building a general internal model, KNN stores the entire training dataset and makes predictions on the fly.

- **Distance Metrics:**  
  To predict the class of a new data point, KNN calculates its distance to all points in the training set. Common distance measures include:
  - **Euclidean Distance:** The straight-line distance between two points.
  - **Manhattan Distance:** The sum of the absolute differences of their coordinates.

- **Voting:**  
  After identifying the `k` closest points (neighbors), KNN uses a majority vote among these neighbors to decide the class of the new data point.

KNN is simple yet powerful, making it a popular choice for introductory studies in machine learning and pattern recognition.

## How It Works

1. **Data Preparation:**  
   The dataset is read from a file (e.g., `iris.txt`) and split into:
   - **Learning Set:** The first 40 samples of each class, used for training.
   - **Test Set:** The remaining samples, used to evaluate the classifier.

2. **Distance Calculation:**  
   For each test sample, the algorithm computes the distance to every training sample using either the Euclidean or Manhattan distance.

3. **Neighbor Voting:**  
   The algorithm selects the `k` nearest neighbors based on the computed distances and uses majority voting among them to predict the test sample's class.

4. **Accuracy Measurement:**  
   The program calculates and prints the classification accuracy for both distance metrics.

## Repository Structure

```
├── iris.txt       # The dataset file (e.g., Iris dataset)
├── KNN.java       # Implementation of the KNN algorithm
└── Main.java      # Main class to run the program
```

## Prerequisites

- **Java JDK 8 (or later):**  
  Ensure that you have the Java Development Kit installed. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.

## How to Compile and Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/knn-java-implementation.git
   cd knn-java-implementation
   ```

2. **Compile the source files:**

   ```bash
   javac *.java
   ```

3. **Run the program:**

   ```bash
   java Main
   ```

   You will be prompted to enter the value of `k` (the number of neighbors).

## Customization

- **Dataset Path:**  
  The dataset path is hardcoded in the `Main` class. If your dataset is located in a different path, update the path accordingly in the code.

- **Parameter Tuning:**  
  Experiment with different values of `k` to see how the classifier's accuracy changes.

## Contributing

Contributions and suggestions for improvements are welcome. Feel free to fork the repository and submit a pull request if you have enhancements or additional features to add.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- The Iris dataset, a classic dataset in pattern recognition and machine learning.
- Numerous online resources and tutorials that have helped shape this educational implementation.
```