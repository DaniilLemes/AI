import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the value of k: ");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        new KNN(Paths.get("/home/rip/IdeaProjects/NAIProject1/src/iris.txt"), k);
    }
}