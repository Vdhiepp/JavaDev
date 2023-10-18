public class SumE {
    public static void main(String[] args) {
        Console c = new Console();
        c.print("Nhập n (5 <= n <= 10): ");
        int n = c.readInt();

        if (n >= 5 && n <= 10) {
            double sum = 0;
            for (int i = 1; i <= n; i++)
                sum += 1.0 / i;
            c.println("Tổng E = " + sum);
        }
    }
}
