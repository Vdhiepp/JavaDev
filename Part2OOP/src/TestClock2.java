import java.io.*;

class TestClock2 {
	public static void main(String args[]) throws IOException {
		System.out.println("creating a new clock");
		Clock a= new Clock();

		BufferedReader inKbd = new BufferedReader(
				new InputStreamReader(System.in));
                String inputLine;

		System.out.print("Hours ? ");
		inputLine = inKbd.readLine();
                int h = Integer.parseInt(inputLine);

		System.out.print("Minutes ? ");
		inputLine = inKbd.readLine();
                int m = Integer.parseInt(inputLine);

		System.out.print("Seconds ? ");
		inputLine = inKbd.readLine();
                int s = Integer.parseInt(inputLine);

		System.out.println("setting a new hour");
		a.setTime(h,m,s);
                System.out.println("Time is now: "+a.getTime());
        }                                                         
}
		
