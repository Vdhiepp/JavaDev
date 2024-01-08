public class NgaySongDenNay {
    public static void main(String[] args) {
        Console c = new Console();
        c.print("Which year were you born ? ");
        int year = c.readInt();
        c.print("Which month were you born ? ");
        int month = c.readInt();
        c.print("Which day were you born ? ");
        int day = c.readInt();
        c.print("Which year is this year ? ");
        int current_year = c.readInt();
        c.print("Which month is this month ? ");
        int current_month = c.readInt();
        c.print("which year is today ? ");
        int current_day = c.readInt();
        int temp = 0;
        for (int i = year; i < current_year ; i++){
            if (i % 4 == 0)
                temp = temp + 1;
        }
        int x = ( ( current_year - year ) * 12 + ( current_month - month ) ) * 30 + ( current_day - day) + 5 * ( current_year - year ) + temp;
        c.println("You have lived about  " + x + "days");
    }
}
