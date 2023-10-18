public class DemXau {
    public static int demTuTrongXau(String xau) {
        String[] tu = xau.split("\\s+");
        int soTu = 0;
        for (String s : tu) {
            if (!s.isEmpty()) {
                soTu++;
            }
        }
        return soTu;
    }

    public static void main(String[] args) {
        Console c = new Console();

        String[] xauNhap = new String[10];

        for (int i = 0; i < 10; i++) {
            c.print("Nhập xâu thứ "+ (i + 1) +": ");
            xauNhap[i] = c.readLine();
        }

        int tongSoTu = 0;
        for (String xau : xauNhap) {
            int soTuTrongXau = demTuTrongXau(xau);
            c.print("Số từ trong xâu: " + soTuTrongXau);
            tongSoTu += soTuTrongXau;
        }

        c.print("Tổng số từ trong 10 xâu là: " + tongSoTu);
    }
}
