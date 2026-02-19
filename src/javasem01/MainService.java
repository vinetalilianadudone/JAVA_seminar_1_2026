package javasem01;

import java.util.*;

public class MainService {
    
    private static final float GRAVITY = 9.80665f;

    public static void main(String[] args) {
        try {
            // ===== 0. uzdevums =====
            System.out.println("0. uzdevums");
            
            String[] names = { 
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
                "Alex", "Emma", "John", "James", "Jane", "Emily", 
                "Daniel", "Neda", "Aaron", "Kate" 
            };
            
            int[] times = { 
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 
                412, 393, 299, 343, 317, 265 
            };
            
            int elements = Math.min(names.length, times.length);
            
            for (int i = 0; i < elements; i++) {
                System.out.println(names[i] + "  " + times[i] + " sec");
            }

            
            // ===== 1. uzdevums =====
            System.out.println("\n1. uzdevums");
            
            double pos = positionCalc(0, 0, 10);
            System.out.println("Position after 10s: " + pos + " m");

            
            // ===== 2. uzdevums =====
            System.out.println("\n2. uzdevums");
            
            int number = 5;
            
            System.out.println("Factorial (for loop) of " + number + ": " 
                + factorialForLoop(number));
            System.out.println("Factorial (recursive) of " + number + ": " 
                + factorialRecursive(number));

            
            // ===== 3. uzdevums =====
            System.out.println("\n3. uzdevums");
            
            double[] array = generateArray(10, 1, 100);
            
            System.out.println("Generated array: " + Arrays.toString(array));
            System.out.println("Mean: " + getMean(array));
            System.out.println("Min: " + getMin(array));
            System.out.println("Max: " + getMax(array));
            System.out.println("Sorted array: " + Arrays.toString(arraySort(array)));

            
            // ===== 4. uzdevums =====
            System.out.println("\n4. uzdevums");
            
            double[][] matrix = generateMatrix(3);
            System.out.println("Dot product row0 col0: " + getProduct(matrix, 0, 0));

            
            // ===== 5. uzdevums =====
            System.out.println("\n5. uzdevums");
            
            System.out.println("Coin flip (1000): " + Arrays.toString(coinFlip(1000)));
            System.out.println("Dice roll (1000): " + Arrays.toString(rollDice(1000)));
            System.out.println("Roll 2 dices until double 6: " + roll2Dices());
            
            // ===== 6. uzdevums =====
            System.out.println("\n6. uzdevums");
            
            byte[] bytes = {
                72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 
                115, 107, 105, 108, 108, 115, 32, 97, 114, 101, 
                32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 
                101, 97, 100, 121, 33
            };
            
            System.out.println(getTextFromBytes(bytes));

            // ===== 7. uzdevums =====
            System.out.println("\n7. uzdevums");
            
            System.out.println(pascalsTriangle(6));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    
    // 1. uzdevums -  aprēķins
    
    private static double positionCalc(double initialVelocity,
                                       double initialPosition, 
                                       double fallingTime) throws Exception {
        if (fallingTime < 0) {
            throw new Exception("Falling time cannot be negative.");
        }
        
        return 0.5 * GRAVITY * Math.pow(fallingTime, 2)
            + initialVelocity * fallingTime
            + initialPosition;
    }

    
    // 2. uzdevums - faktoriāls
    
    private static int factorialForLoop(int N) throws Exception {
        if (N < 0) {
            throw new Exception("Cannot calculate factorial of negative number.");
        }
        
        int result = 1;
        
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        
        return result;
    }

    private static int factorialRecursive(int N) throws Exception {
        if (N < 0) {
            throw new Exception("Cannot calculate factorial of negative number.");
        }
        
        if (N <= 1) {
            return 1;
        }
        
        return N * factorialRecursive(N - 1);
    }

    
    // 3. uzdevums - masīvu operācijas
    
    private static double[] generateArray(int N, double lower, double upper) throws Exception {
        if (N <= 0 || lower >= upper) {
            throw new Exception("Invalid array generation parameters.");
        }
        
        double[] array = new double[N];
        Random rand = new Random();
        
        for (int i = 0; i < N; i++) {
            array[i] = lower + (upper - lower) * rand.nextDouble();
        }
        
        return array;
    }

    private static double getMean(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Array is invalid.");
        }
        
        double sum = 0;
        
        for (double v : array) {
            sum += v;
        }
        
        return sum / array.length;
    }

    private static double getMin(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Array is invalid.");
        }
        
        double min = array[0];
        
        for (double v : array) {
            if (v < min) {
                min = v;
            }
        }
        
        return min;
    }

    private static double getMax(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Array is invalid.");
        }
        
        double max = array[0];
        
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        
        return max;
    }

    private static double[] arraySort(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Array is invalid.");
        }
        
        double[] sorted = array.clone();
        
        // Bubble sort
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    double temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        
        return sorted;
    }

    
    // 4. uzdevums - matricas
    
    private static double[][] generateMatrix(int N) throws Exception {
        if (N <= 0) {
            throw new Exception("Matrix size must be positive.");
        }
        
        double[][] matrix = new double[N][N];
        Random rand = new Random();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = rand.nextDouble() * 10;
            }
        }
        
        return matrix;
    }

    private static double getProduct(double[][] matrix, int i, int j) throws Exception {
        if (matrix == null || i >= matrix.length || j >= matrix.length) {
            throw new Exception("Invalid indices for matrix product.");
        }
        
        double sum = 0;
        
        for (int k = 0; k < matrix.length; k++) {
            sum += matrix[i][k] * matrix[k][j];
        }
        
        return sum;
    }

    
    // 5. uzdevums - monēta un kauliņi
    
    private static double[] coinFlip(int N) throws Exception {
        if (N <= 0) {
            throw new Exception("Number of flips must be positive.");
        }
        
        Random rand = new Random();
        int heads = 0;
        int tails = 0;
        
        for (int i = 0; i < N; i++) {
            if (rand.nextBoolean()) {
                heads++;
            } else {
                tails++;
            }
        }
        
        double ratio = tails == 0 ? 0 : (double) heads / tails;
        
        return new double[] { heads, tails, ratio };
    }

    private static int[] rollDice(int N) throws Exception {
        if (N <= 0) {
            throw new Exception("Number of rolls must be positive.");
        }
        
        Random rand = new Random();
        int[] counts = new int[6];
        
        for (int i = 0; i < N; i++) {
            counts[rand.nextInt(6)]++;
        }
        
        return counts;
    }

    private static int roll2Dices() throws Exception {
        Random rand = new Random();
        int tries = 0;
        
        while (true) {
            tries++;
            
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            
            if (d1 == 6 && d2 == 6) {
                break;
            }
        }
        
        return tries;
    }
    
    // 6. uzdevums - baiti uz tekstu
    
    private static String getTextFromBytes(byte[] array) throws Exception {
        if (array == null) {
            throw new Exception("Byte array is null.");
        }
        
        return new String(array);
    }
    
    // 7. uzdevums - Pascala trijstūris
    
    private static String pascalsTriangle(int level) throws Exception {
        if (level < 0) {
            throw new Exception("Level cannot be negative.");
        }
        
        int[] row = new int[level + 1];
        
        for (int i = 0; i <= level; i++) {
            row[i] = factorialForLoop(level) 
                / (factorialForLoop(i) * factorialForLoop(level - i));
        }
        
        return Arrays.toString(row);
    }
}