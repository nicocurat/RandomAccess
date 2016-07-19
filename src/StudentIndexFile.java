import java.io.Serializable;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class StudentIndexFile implements Comparable<StudentIndexFile>, Serializable{

    private Register register;
    private long position;

    public StudentIndexFile(Register register, long position){
        this.register = register;
        this.position = position;
    }

    public long getPosition() {
        return position;
    }

    public Register getRegister() {
        return register;
    }

    @Override
    public int compareTo(StudentIndexFile o) {
        return (int) (this.register.getStudent().getId() - o.getRegister().getStudent().getId());
    }
}
