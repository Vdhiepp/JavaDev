package BT18;

public class MainBt18 {
    public static void main(String[] args) {
        Course course1 = new Course("Lập trình Java");
        course1.addStudent("Hiệp");
        course1.addStudent("Hùng");
        course1.addStudent("Thư");

        Course course2 = new Course("Lập trình Android");
        course2.addStudent("Hưng");
        course2.addStudent("Định");

        System.out.println("Khóa 1: " + course1.getName());
        System.out.println("Số học sinh: " + course1.getNumberOfStudents());
        System.out.println("Danh sách học sinh: " + course1.getStudents());

        System.out.println("\nKhóa 2: " + course2.getName());
        System.out.println("Số học sinh: " + course2.getNumberOfStudents());
        System.out.println("Danh sách học sinh: " + course2.getStudents());
    }
}
