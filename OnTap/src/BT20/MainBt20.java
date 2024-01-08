package BT20;

public class MainBt20 {
    public static int count(String str, char a){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int kQua = count("Welcome", 'e');
        System.out.println("Số lần xuất hiện của ký tự là: " + kQua);
    }
}
