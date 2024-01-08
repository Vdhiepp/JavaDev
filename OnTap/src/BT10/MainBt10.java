package BT10;

import static BT10.Fan.SLOW;
import static BT10.Fan.FAST;
import static BT10.Fan.MEDIUM;

public class MainBt10 {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.turnOn();

        Fan fan1 = new Fan();
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.turnOn();

        Fan fan2 = new Fan();
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("white");
        fan2.turnOff();

        System.out.println("Fan 0: " + fan);
        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 2: " + fan2);
    }
}
