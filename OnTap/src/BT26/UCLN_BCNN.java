package BT26;

public class UCLN_BCNN {
    public static int uscln(int m, int n) {
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    public static int bscnn(int m, int n) {
        return m * n / uscln(m, n);
    }
}
