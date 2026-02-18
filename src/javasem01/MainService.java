package javasem01;

import java.util.*;

public class MainService {
	
	private static final float GRAVITY = 9.80665f;

    public static void main(String[] args) throws Exception {

        // 0. uzd
        System.out.println("0. uzdevums");

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
                "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
                "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
                299, 343, 317, 265 };

        int howManyElements = names.length;
        if(names.length > times.length) {
        	howManyElements = times.length;
        }
        
        for (int i = 0; i < howManyElements; i++) {
            System.out.println(names[i] + "  " + times[i] + " sec");
        }

        // 1. uzd
        System.out.println("\n1. uzdevums");

        double pos = positionCalc(10, 5, 20);
        System.out.println("Position after 10s: " + pos + " m");

        // 2. uzd
        System.out.println("\n2. uzdevums");

        int number = 5;
        System.out.println("Factorial (for loop) of " + number + ": " + factorialForLoop(number));
        System.out.println("Factorial (recursive) of " + number + ": " + factorialRecursive(number));

        // 3. uzd
        System.out.println("\n3. uzdevums");

        double[] array = generateArray(10, 1, 100);

        System.out.println("Generated array: " + Arrays.toString(array));
        System.out.println("Mean: " + getMean(array));
        System.out.println("Min: " + getMin(array));
        System.out.println("Max: " + getMax(array));
        System.out.println("Sorted array: " + Arrays.toString(arraySort(array)));
    }

    // 1. uzd aprēķins
    private static double positionCalc(double initialVelocity,
                               double initialPosition, double fallingTime) throws Exception {
    	
    	if(initialVelocity >= 0 && initialPosition >= 0 && fallingTime >= 0) {
    		return 0.5 * (GRAVITY) * Math.pow(fallingTime, 2)
                    + initialVelocity * fallingTime
                    + initialPosition;
    	}
    	else {
    		throw new Exception("Nevar aprēķināt, jo kāds no ievades datiem nav pareiza vērtība.");
    	}
    }

    // 2. uzd faktoriāls ar for ciklu
    private static int factorialForLoop(int N) throws Exception {
        if (N < 0) {
            throw new Exception("Faktoriālu nevar aprēķināt negatīvam skaitlim.");
        }

        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    // 2. uzd rekursīvi
    private static int factorialRecursive(int N) throws Exception {
        if (N < 0) {
            throw new Exception("Faktoriālu nevar aprēķināt negatīvam skaitlim.");
        }
        if (N <= 1) return 1;

        return N * factorialRecursive(N - 1);
    }

    // 3. uzd masīva ģenerēšana
    private static double[] generateArray(int N, double lower, double upper) throws Exception {
        if (N <= 0 || lower >= upper) {
            throw new Exception("Nepareizi masīva ģenerēšanas parametri.");
        }

        double[] array = new double[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            array[i] = lower + (upper - lower) * rand.nextDouble();
        }

        return array;
    }

    // 3. uzd vidējā vērtība
    private static double getMean(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Masīvs nav derīgs vidējās vērtības aprēķinam.");
        }

        double sum = 0;

        for (double value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    // 3. uzd minimums
    private static double getMin(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Masīvs nav derīgs minimuma noteikšanai.");
        }

        double min = array[0];

        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    // 3. uzd maksimums
    private static double getMax(double[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Masīvs nav derīgs maksimuma noteikšanai.");
        }

        double max = array[0];

        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    // 3. uzd Bubble Sort
    private static double[] arraySort(double[] array) throws Exception {

        if (array == null || array.length == 0) {
            throw new Exception("Masīvs nav derīgs kārtošanai.");
        }

        double[] sorted = array.clone();

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
}
