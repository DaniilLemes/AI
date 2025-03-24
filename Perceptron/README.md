# Perceptron in Java

This repository contains a simple implementation of the Perceptron algorithm in Java. It is designed as an educational example to demonstrate how a basic neural network model can be used for binary classification, using the Iris dataset as a case study.

## What is a Perceptron?

The Perceptron is one of the earliest and simplest models of a neural network. It is a linear classifier that makes predictions based on a weighted sum of the input features. Here are the key concepts:

- **Linear Classifier:**  
  The perceptron computes a weighted sum of the input features and subtracts a threshold (also called bias). If the result is greater than or equal to zero, it outputs one class; otherwise, it outputs the other class.

- **Learning Process:**  
  The algorithm learns by adjusting the weights and threshold based on errors in its predictions. For every misclassified example, it updates the weights in a way that reduces the error.

- **Binary Classification:**  
  The perceptron is naturally suited for binary classification tasks. In this example, it distinguishes between one class of Iris (Iris-setosa) and all other classes.

## How It Works

1. **Data Preparation:**  
   - The Iris dataset is read from a file (`iris.txt`).
   - Each data point is converted into a feature vector and assigned a binary label: `1` for Iris-setosa, and `0` for the other classes.
   - The dataset is shuffled and split into a training set (70%) and a test set (30%).

2. **Training:**  
   - The perceptron is initialized with random weights and a threshold.
   - During training, for each data point in the training set, the perceptron predicts the output. If the prediction is incorrect, it adjusts the weights and threshold using the learning rate.

3. **Testing:**  
   - After training, the perceptron is evaluated on the test set to determine its accuracy in classifying the data points.

## Repository Structure

```
├── iris.txt           # The Iris dataset file
├── Perceptron.java    # Perceptron algorithm implementation
├── DataPoint.java     # Class representing a data point with label and features
└── Main.java          # Main class for training and testing the Perceptron
```

## Prerequisites

- **Java JDK 8 or later:**  
  Ensure you have the Java Development Kit installed. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.

## How to Compile and Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/perceptron-java-implementation.git
   cd perceptron-java-implementation
   ```

2. **Compile the source files:**

   ```bash
   javac *.java
   ```

3. **Run the program:**

   ```bash
   java Main
   ```

   The program will read the dataset, train the perceptron, and print the classification accuracy.

## Customization

- **Learning Parameters:**  
  You can experiment with different values for the learning rate, threshold, and the number of epochs in the `Main` class.

- **Dataset Path:**  
  If your `iris.txt` file is located in a different directory, update the file path in the code accordingly.

## Contributing

Contributions, feedback, and suggestions are welcome! Feel free to fork the repository and submit a pull request with any improvements or additional features.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the creators of the Iris dataset for providing a classic dataset in machine learning.
- Special thanks to the online community and educational resources that have made learning about neural networks accessible and engaging.
```