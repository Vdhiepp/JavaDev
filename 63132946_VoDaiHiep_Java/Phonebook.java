import java.util.Scanner;
import java.util.Vector;

class Phonebook {
    private Vector<Entry> entries;

    public Phonebook() {
        entries = new Vector<>();
    }

    public void add(String name, String phone) {
        entries.add(new Entry(name, phone));
    }

    public String getNumber(String name) {
        for(Entry e : entries) {
            if(e.name.equals(name)) {
                return e.phone;
            }
        }
        return null;
    }

    // Sinh viên cài đặt phương thức updateNumber() theo dạng
    public void updateNumber(String name, String newNumber) {
        for (Entry entry : entries){
            if (entry.name.equals(name)){
                entry.phone = newNumber;
                return;
            }
        }
    }

    // Sinh viên cài đặt phương thức remove() theo dạng
    public void remove(String name) {
        for (Entry entry : entries){
            if (entry.name.equals(name)){
                entries.remove(entry);
                return;
            }
        }
    }

    public void listAll() {
        System.out.println("Phone book:");
        for(Entry entry : entries) {
            System.out.println(entry.name + ": " + entry.phone);
        }
    }

    // Phương thức main để test
    public static void main(String[] args) {

        Phonebook pb = new Phonebook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Update");
            System.out.println("4. Remove");
            System.out.println("5. List");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            if(choice == 0) {
                break;
            }

            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Number: ");
                    String number = scanner.nextLine();

                    pb.add(name, number);
                    break;
                case 2:
                    System.out.print("Name to search: ");
                    name = scanner.nextLine();

                    String result = pb.getNumber(name);
                    if(result == null) {
                        System.out.println("Not found.");
                    } else {
                        System.out.println(result);
                    }
                    break;
                // Sinh viên viết các case còn lại (3,4) để test
                case 3:
                    System.out.print("Name to update: ");
                    name = scanner.nextLine();
                    System.out.print("New number: ");
                    String newNumber = scanner.nextLine();
                    pb.updateNumber(name, newNumber);
                    break;
                case 4:
                    System.out.print("Name to remove: ");
                    name = scanner.nextLine();
                    pb.remove(name);
                    break;
                case 5:
                    pb.listAll();
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}

class Entry {
    String name;
    String phone;

    public Entry(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}


