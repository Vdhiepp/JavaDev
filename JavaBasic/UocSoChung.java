public class UocSoChung {
    public static int mcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return mcd(y, x % y);
        }
    }
    public static void main(String[] args) {
        Console c = new Console();
        c.print("type in the first number : ");
        int a = c.readInt();
        c.print("type in the second number : ");
        int b = c.readInt();
        c.println("the maximal common divider is "+mcd(a,b));
    }
}
