import java.util.Arrays;

public class SapXepDay {
    public static void main(String[] args) {
        Console c = new Console();
        int[] a; a = new int[20];
        int tong = 0;

        for (int i = 0; i < 20; i++) {
            a[i] = c.readInt();
            tong += a[i];
        }

        double trungBinh = (double) tong / 20;
        c.println("Giá trị trung bình của các phần tử trong dãy: " + trungBinh);

        c.println("Các phần tử bé hơn giá trị trung bình:");
        for (int i = 0; i < 20; i++)
            if (a[i] < trungBinh)
                c.print(a[i] + " ");

        Arrays.sort(a);
        c.println("\nDãy sau khi sắp xếp tăng dần:");
        for (int i = 0; i < 20; i++)
            c.print(a[i] + " ");
    }
}
