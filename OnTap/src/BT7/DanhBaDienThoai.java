package BT7;

import java.util.Vector;

public class DanhBaDienThoai {
    Vector<Entry> danhBa;

    public DanhBaDienThoai() {
        danhBa = new Vector<>();
    }

    public void themEntry(String hoTen, String soDienThoai) {
        danhBa.add(new Entry(hoTen, soDienThoai));
    }

    public String timSoDienThoai(String hoTen) {
        for (Entry entry : danhBa) {
            if (entry.getHoTen().equalsIgnoreCase(hoTen)) {
                return entry.getSoDienThoai();
            }
        }
        return "Không tìm thấy số điện thoại cho " + hoTen;
    }

    public boolean suaSoDienThoai(String hoTen, String soDienThoaiMoi) {
        for (Entry entry : danhBa) {
            if (entry.getHoTen().equalsIgnoreCase(hoTen)) {
                entry.setSoDienThoai(soDienThoaiMoi);
                return true;
            }
        }
        return false;
    }

    public boolean xoaEntry(String hoTen) {
        for (Entry entry : danhBa) {
            if (entry.getHoTen().equalsIgnoreCase(hoTen)) {
                danhBa.remove(entry);
                return true;
            }
        }
        return false;
    }

    public void hienThiDanhBa() {
        for (Entry entry : danhBa) {
            System.out.println("Họ tên: " + entry.getHoTen() + ", Số điện thoại: " + entry.getSoDienThoai());
        }
    }
}
