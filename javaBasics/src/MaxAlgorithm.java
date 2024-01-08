public class MaxAlgorithm {
    public static void main(String[] args) {
        int[] array = {-20, 19, 1, 5, -1, 27, 19, 5};
        int max;
        max = array[0];

        for (int value : array) {
            if (value > max)
                max = value;
        }
        System.out.println("The maximum of this array is: " + max);

// dòng lệnh cơ bản hồi giờ sử dụng
/*
        int value;
        for (int i =0 ; i < array.length ; i = i + 1){
            value = array[i];
            if (value > max)
                max = value;
        }
*/
    }
}
