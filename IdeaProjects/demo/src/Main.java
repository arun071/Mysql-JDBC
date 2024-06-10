import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------");
        System.out.println("* * MYSQL * * ");
        System.out.println("--------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Url");
        String Url = sc.next();
        System.out.println("Enter User Name");
        String UserName = sc.next();
        System.out.println("Enter Password");
        String Password = sc.next();
        JDBC Mysql = new JDBC(Url, UserName, Password);
        while (true) {
            System.out.println("\nWelcome to MySql" +
                    "\n1.Create Database" +
                    "\n2.Select Database" +
                    "\n3.Delete Database" +
                    "\n4.Show All Database" +
                    "\n5.Create Table" +
                    "\n6.Show Table" +
                    "\n0.Exit\n"
            );
            int num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.print("Enter Db Name: ");
                    Mysql.createDb(sc.next());
                }
                case 2 -> {
                    System.out.print("Enter Db Name: ");
                    Mysql.useDb(sc.next());
                }
                case 3 -> {
                    System.out.print("Delete Db Name: ");
                    Mysql.deleteDb(sc.next());
                }
                case 4 -> Mysql.ShowDb();
                case 5 -> {
                    System.out.print("Enter Table Name: ");
                    Mysql.createTable(sc.next());
                }
                case 6 -> {
                    System.out.print("Enter Db Name: ");
                    Mysql.ShowAllTable(sc.next());
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
