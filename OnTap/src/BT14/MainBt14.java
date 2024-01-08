package BT14;

public class MainBt14 {
    public static void main(String[] args) {
        int i, j;
        System.out.println("Pattern I");
        for (i = 1; i <= 6; i++){
            for (j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.print("\n");
        }
        System.out.println("Pattern II");
        for (i = 0; i <= 6; i++){
            for (j = 1; j <= 6 - i; j++)
                System.out.print(j + " ");
            System.out.print("\n");
        }
        System.out.println("Pattern III");
        for (i = 1; i <= 6; i++) {
            for (j = 1; j <= 6 - i; j++) {
                System.out.print("  ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(k + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Pattern IV");
        for (i = 1; i <= 6; i++) {
            for (j = 1; j < i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= 6 - i + 1; k++) {
                System.out.print(k);
                if (k < 6 - i + 1) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
