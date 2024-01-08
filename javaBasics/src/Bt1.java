public class Bt1 {
    public static void main(String[] args) {
        Console c = new Console();
        c.print("Which year were you born ? ");
        int year = c.readInt();
        c.print("Which month were you born ? ");
        int month = c.readInt();
        c.print("Which day were you born ? ");
        int day = c.readInt();
        int x = ( ( 2007 - year ) * 12 + ( 12 - month ) ) * 30 + (30-day) ;
        c.println("You have lived almost " + x + "days");
    }
}
