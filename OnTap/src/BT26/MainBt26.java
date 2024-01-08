package BT26;

import static BT26.UCLN_BCNN.bscnn;
import static BT26.UCLN_BCNN.uscln;

public class MainBt26 {
    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        int usclnResult = uscln(a, b);
        int bscnnResult = bscnn(a, b);

        System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + usclnResult);
        System.out.println("Bội số chung nhỏ nhất của " + a + " và " + b + " là: " + bscnnResult);
    }
}
