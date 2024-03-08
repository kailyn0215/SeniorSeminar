import java.util.ArrayList;

public class Session {

    private String name;
    private int id;
    private String proctor;
    private int popularity;
    private int people = 0;
    private int people2 = 0;
    private boolean twice = false;

    private ArrayList<Integer> students = new ArrayList<Integer>();
    private ArrayList<Integer> students2 = new ArrayList<Integer>();

    public Session(String seshName, int seshId, String seshProctor, int seshPopularity) {
        name = seshName;
        id = seshId;
        proctor = seshProctor;
        popularity = seshPopularity;
        //System.out.println("Added " + name + ", ID: " + id + ", Proctored by " + proctor);
    }

    public Session(int seshId) {
        id = seshId;
    }

    public String getName() {
        return name;
    }

    public String getProctor() {
        return proctor;
    }

    public void setPopularity(int pop) {
        popularity = pop;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getID() {
        return id;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople() {
        people++;
    }

    public void setStudents(int id) {
        students.add(id);
    }

    public void printStudents() {
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }  
    }

    public boolean getDoubleSession() {
        return twice;
    }

    public void setDoubleSession(boolean set) {
        twice = set; 
    }

    public int getPeople2() {
        return people2;
    }

    public void setPeople2() {
        people2++;
    }

    public void setStudents2(int id) {
        students2.add(id);
    }

    public void printStudents2() {
        for(int i = 0; i < students2.size(); i++) {
            System.out.println(students2.get(i));
        } 
    }

}
