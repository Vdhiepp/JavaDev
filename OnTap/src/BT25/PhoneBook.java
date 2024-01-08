package BT25;

import java.util.Hashtable;

public class PhoneBook {
    Hashtable<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new Hashtable<>();
    }

    public void addEntry(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        System.out.println("Đã thêm " + name + " vào danh bạ với số điện thoại: " + phoneNumber);
    }

    public String findPhoneNumber(String name) {
        String phoneNumber = phoneBook.get(name);
        return phoneNumber != null ? phoneNumber : "Không tìm thấy " + name + " trong danh bạ";
    }

    public void editPhoneNumber(String name, String newPhoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.put(name, newPhoneNumber);
            System.out.println("Số điện thoại của " + name + " đã được cập nhật thành " + newPhoneNumber);
        } else {
            System.out.println(name + " không tồn tại trong danh bạ.");
        }
    }

    public void removeEntry(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Đã xóa " + name + " khỏi danh bạ.");
        } else {
            System.out.println(name + " không tồn tại trong danh bạ.");
        }
    }

    public void listEntries() {
        System.out.println("Danh bạ điện thoại:");
        for (String name : phoneBook.keySet()) {
            String phoneNumber = phoneBook.get(name);
            System.out.println(name + ": " + phoneNumber);
        }
    }
}
