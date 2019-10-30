package Se.Lexicon.John.models;

public class Student {
    private static int studentCounter = 1;
    private int id;
    private String name;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Student(String name) {
        setId(studentCounter++);
        this.setName(name);
    }
}
