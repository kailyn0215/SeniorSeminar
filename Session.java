public class Session {

    private String name;
    private int id;
    private String proctor;
    private int popularity;

    public Session(String seshName, int seshId, String seshProctor, int seshPop) {
        name = seshName;
        id = seshId;
        proctor = seshProctor;
        popularity = seshPop;
        System.out.println("Added " + name + ", ID: " + id + ", Proctored by " + proctor);
    }

    public String getName() {
        return name;
    }

    public String getProctor() {
        return proctor;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getID() {
        return id;
    }
}
