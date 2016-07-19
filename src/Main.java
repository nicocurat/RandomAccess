import java.util.Scanner;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class Main {
    private static Scanner scanner;
    private static Start start;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        start = new Start();
        userInput();
    }

    public static void userInput(){
        menu();
        int option = scanner.nextInt();
        switch (option){
            case 1:
                start.add();
                userInput();
                break;
            case 2:
                start.delete();
                userInput();
                break;
            case 3:
                start.change();
                userInput();
                break;
            case 4:
                start.listStudents();
                userInput();
                break;
            case 5:
                start.createIndexFile();
                userInput();
                break;
            case 6:
                start.loadIndexFile();
                userInput();
                break;
            case 7:
                start.getCount();
                userInput();
                break;
            case 8:default:
                start.close();
                break;
        }
    }

    public static void menu(){
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Change Student");
        System.out.println("4. Display Students");
        System.out.println("5. Generate index file");
        System.out.println("6. Load index file");
        System.out.println("7. Get count of registers");
        System.out.println("8. Exit");
    }
}