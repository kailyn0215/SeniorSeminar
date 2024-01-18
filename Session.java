public class Session {

    private String name;
    private int id;
    private String proctor;

    public Session(String seshName, int seshId, String seshProctor) {
        name = seshName;
        id = seshId;
        proctor = seshProctor;
        System.out.println("Added " + name + ", ID: " + id + ", Proctored by " + proctor);
    }    
}
