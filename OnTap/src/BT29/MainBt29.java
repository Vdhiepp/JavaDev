package BT29;

public class MainBt29 {
    public static int average(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public static double average(double[] array) {
        if (array.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6};
        double[] doubleArray = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};

        int intAverage = average(intArray);
        double doubleAverage = average(doubleArray);

        System.out.println("Giá trị trung bình của dãy số nguyên: " + intAverage);
        System.out.println("Giá trị trung bình của dãy số thực: " + doubleAverage);
    }
}
