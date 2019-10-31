package Se.Lexicon.John.models;

public class Student {
    private int id;
    private String name;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Student(int id, String name) {
        this(name);
        this.setId(id);
    }

    public Student(String name) {
        this.setName(name);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + '\n';
    }
}
