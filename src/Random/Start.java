package Random;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class Start {

    private StudentFile studentFile;
    private Scanner scanner;

    public Start(){
        this.scanner = new Scanner(System.in);
        try{
            this.studentFile = new StudentFile("Students.dat");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void add(){
        Random random = new Random();
        System.out.print("Random.Student's name: ");
        String name = scanner.next();
        Student student = new Student(random.nextInt(1000 - 1) + 1,name);
        Register register = new Register(student,true);
        try{
            studentFile.addRegister(register);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(){
        System.out.print("ID: ");
        long id = scanner.nextLong();
        try{
            if(!studentFile.delete(id))
                System.out.println("Error: record " + id + " could't be deleted");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void change(){
        System.out.print("ID: ");
        long id = scanner.nextLong();
        try{
            System.out.print("New name: ");
            String name = scanner.next();
            studentFile.change(id, name);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listStudents(){
        try{
            studentFile.listRegisters();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createIndexFile(){
        try{
            studentFile.createIndexFile("IndexFile");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void loadIndexFile(){
        try{
            studentFile.loadFile("IndexFile");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void getCount(){
        try{
            System.out.println(studentFile.countRegisters());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try{
            studentFile.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}