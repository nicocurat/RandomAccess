package Random;

import java.io.Serializable;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class Register implements Serializable{

    private Student student;
    private boolean isAvailable;

    public Register(){}

    public Register(Student student, boolean isAvailable) {
        this.student = student;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Student getStudent() {
        return student;
    }

}
