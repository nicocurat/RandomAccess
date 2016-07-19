import java.io.Serializable;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class Student implements Serializable{

    private long id;
    private String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = Utilities.adapt(name, 16);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Utilities.adapt(name, 16);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
