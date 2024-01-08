package BT12;

import java.util.Arrays;

public class MainBt12 {
    public static int[] DaoCach1(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[arr.length - 1 - i];
        }
        return array;
    }

    public static void DaoCach2(int[] arr) {
        int a = 0;
        int b = arr.length - 1;

        while (a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Đảo ngược dãy số nguyên bằng cách tạo mảng mới
        int[] daocach1 = DaoCach1(array);
        System.out.println("Reversed with new array: " + Arrays.toString(daocach1));

        // Đảo ngược dãy số nguyên mà không tạo mảng mới
        DaoCach2(array);
        System.out.println("Reversed in place: " + Arrays.toString(array));
    }
}
