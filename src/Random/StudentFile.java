package Random;

import java.io.*;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class StudentFile {

    private File file;
    private RandomAccessFile raf;
    // el size es 27: 8 del long(id), 16+2 del string(name), 1 del boolean (available).
    private int size = 27;
    private BinarySearchTree<StudentIndexFile> binarySearchTree;

    public StudentFile(String fileName) throws Exception{
        this.file = new File(fileName);
        this.raf = new RandomAccessFile(file, "rw");
        this.binarySearchTree = new BinarySearchTree<>();
    }

    public void start() throws Exception{
        this.raf.seek(0);
    }

    public boolean end() throws Exception{
        return (raf.getFilePointer() > raf.length());
    }

    public void close() throws Exception{
        raf.close();
    }

    private void write(Register register) throws Exception{
        raf.writeLong(register.getStudent().getId());
        raf.writeUTF(register.getStudent().getName());
        raf.writeBoolean(register.isAvailable());
    }

    public void addRegister(Register register) throws Exception{
        raf.seek(raf.length());
        write(register);
    }

    public Register read() throws Exception{
        return new Register(new Student(raf.readLong(), raf.readUTF()), raf.readBoolean());
    }

    public long countRegisters() throws IOException{
        return raf.length()/this.size;
    }

    private Register search(long id) throws Exception{
        long count = countRegisters();
        start();
        Register register;
        for(int i = 0; i < count; i++){
            register = read();
            if(register.isAvailable() && (register.getStudent().getId() == id))
                return register;
        }
        return new Register();
    }

    public void change(long id, String name) throws Exception{
        Register register = search(id);
        if((register != null) && (register.isAvailable())){
            raf.seek(raf.getFilePointer() - size);
            register.getStudent().setName(name);
            write(register);
        }
    }

    public boolean delete(long id) throws Exception{
        Register register = search(id);
        if((register != null) && (register.isAvailable())){
            raf.seek(raf.getFilePointer() - size);
            register.setAvailable(false);
            write(register);
            return true;
        }
        return false;
    }

    public void listRegisters() throws Exception {
        start();
        Register aux = read();
        while(!end()){
            if(aux.isAvailable())
                System.out.println(aux.getStudent().toString());
            aux = read();
        }
    }

    public void createIndexFile(String filename) throws Exception {
        long count = countRegisters();
        start();
        Register register;
        for(int i = 0; i < count; i++){
            register = read();
            if(register.isAvailable())
                binarySearchTree.insertar(new StudentIndexFile(register, raf.getFilePointer() - size));
        }
        saveFile(filename);
    }

    private void saveFile(String filename) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(binarySearchTree);
        objectOutputStream.close();
    }

    public void loadFile(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        binarySearchTree = (BinarySearchTree<StudentIndexFile>) objectInputStream.readObject();
        objectInputStream.close();
    }

}
