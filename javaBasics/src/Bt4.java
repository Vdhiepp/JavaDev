public class Bt4 {
    public static void main(String[] args) {
        Console c = new Console();
        int sum = 0, count = 0, max = 0, min = 0;

        while (true) {
            int number = c.readInt();
            if (number == 0) {
                break;
            }
            sum += number;
            count++;
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        c.print("Trung bình cộng của dãy số là: " + sum/count + "\n");
        c.print("Số lớn nhất trong dãy số là: " + max + "\n");
        c.print("Số nhỏ nhất trong dãy số là: " + min + "\n");
    }
}
