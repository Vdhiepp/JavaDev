public class Bt3 {
    public static void main(String[] args) {
        Console c = new Console();
        c.print("Nhập số phút gọi: ");
        int minutes = c.readInt();
        int money = 0;
        if (minutes <= 200)
            money = 27000 + 120 * minutes;
        else if (minutes <= 400)
            money = 27000 + 120 * 200 + (minutes - 200) * 80;
        else money = 27000 + 120 * 200 + 200 * 80 + (minutes - 400) * 40;
        c.println("Tiền điện thoại của bạn là:  " + money + "đ");
    }
}
