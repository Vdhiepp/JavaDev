package BT25;

import java.util.Scanner;

public class MainBt25 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm");
            System.out.println("2. Tìm kiếm");
            System.out.println("3. Sửa đổi");
            System.out.println("4. Xóa");
            System.out.println("5. Liệt kê danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addEntry(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Nhập tên cần tìm: ");
                    name = scanner.nextLine();
                    String result = phoneBook.findPhoneNumber(name);
                    System.out.println(result);
                    break;
                case 3:
                    System.out.print("Nhập tên cần sửa đổi số điện thoại: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại mới: ");
                    phoneNumber = scanner.nextLine();
                    phoneBook.editPhoneNumber(name, phoneNumber);
                    break;
                case 4:
                    System.out.print("Nhập tên cần xóa: ");
                    name = scanner.nextLine();
                    phoneBook.removeEntry(name);
                    break;
                case 5:
                    phoneBook.listEntries();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
