import java.util.Random;

public class SortingComplexity {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Function to copy an array manually
    public static int[] copyArray(int[] original) {
        int n = original.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    // Method to measure execution time
    public static double measureTime(int[] arr, String sortType) {
        long startTime = System.currentTimeMillis(); // Record start time

        // Call the corresponding sorting method
        switch (sortType) {
            case "Bubble Sort":
                bubbleSort(arr);
                break;
            case "Selection Sort":
                selectionSort(arr);
                break;
            case "Insertion Sort":
                insertionSort(arr);
                break;
        }

        long endTime = System.currentTimeMillis(); // Record end time
        return (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
    }

    public static void main(String[] args) {
        int size = 1000;
        Random random = new Random();
        int[] testArray = new int[size];

        // Fill the array with random numbers
        for (int i = 0; i < size; i++) {
            testArray[i] = random.nextInt(1,10000);
        }

        // Sorting algorithms to test
        String[] sortingAlgorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort"};

        // Measure and print execution time for each sorting algorithm
        for (String algo : sortingAlgorithms) {
            int[] arrCopy = copyArray(testArray); // Using manual copy function
            double timeTaken = measureTime(arrCopy, algo);
            System.out.println(algo + ": " + timeTaken + " seconds");
        }
    }
}
