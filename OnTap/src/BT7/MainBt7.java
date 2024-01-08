package BT7;

import java.util.Scanner;

public class MainBt7 {
    public static void main(String[] args) {
        DanhBaDienThoai danhBa = new DanhBaDienThoai();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1-Thêm, 2-Tìm kiếm, 3-Sửa đổi, 4-Xóa, 5-Liệt kê danh bạ, 0-Thoát");
            System.out.print("Chọn chức năng: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập Họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập Số điện thoại: ");
                    String soDienThoai = scanner.nextLine();
                    danhBa.themEntry(hoTen, soDienThoai);
                    break;
                case 2:
                    System.out.print("Nhập Họ tên cần tìm kiếm: ");
                    String hoTenTimKiem = scanner.nextLine();
                    String ketQuaTimKiem = danhBa.timSoDienThoai(hoTenTimKiem);
                    System.out.println(ketQuaTimKiem);
                    break;
                case 3:
                    System.out.print("Nhập Họ tên cần sửa đổi số điện thoai: ");
                    String hoTenSua = scanner.nextLine();
                    System.out.print("Nhập số điện thoại mới: ");
                    String soDienThoaiMoi = scanner.nextLine();
                    boolean suaKetQua = danhBa.suaSoDienThoai(hoTenSua, soDienThoaiMoi);
                    if (suaKetQua) {
                        System.out.println("Đã sửa đổi số điện thoại cho " + hoTenSua);
                    } else {
                        System.out.println("Không tìm thấy " + hoTenSua + " trong danh bạ.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập Họ tên cần xóa: ");
                    String hoTenXoa = scanner.nextLine();
                    boolean xoaKetQua = danhBa.xoaEntry(hoTenXoa);
                    if (xoaKetQua) {
                        System.out.println("Đã xóa " + hoTenXoa + " khỏi danh bạ.");
                    } else {
                        System.out.println("Không tìm thấy " + hoTenXoa + " trong danh bạ.");
                    }
                    break;
                case 5:
                    danhBa.hienThiDanhBa();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}