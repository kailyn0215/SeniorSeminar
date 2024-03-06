public class Student {

    private String time;
    private String name;
    private String user;
    private int[] choices = {0, 0, 0, 0, 0};
    private int[] sessions = {0, 0, 0, 0, 0};
    private int id;

    public Student(String stuTime, String stuName, String stuUser, int stuChoice1, int stuChoice2, int stuChoice3, int stuChoice4, int stuChoice5, int stuId) {
        time = stuTime;
        name = stuName;
        user = stuUser;
        choices[0] = stuChoice1;
        choices[1] = stuChoice2;
        choices[2] = stuChoice3;
        choices[3] = stuChoice4;
        choices[4] = stuChoice5;
        id = stuId;
        //System.out.println("Added " + name + " to the roster.");
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setSesh(int timeSlot, int seshID) {
        sessions[timeSlot] = seshID;
    }

    public int getSesh(int timeSlot) {
        return sessions[timeSlot];
    }

    public int getChoice1() {
        return choices[0];
    }

    public int getChoice2() {
        return choices[1];
    }

    public int getChoice3() {
        return choices[2];
    }

    public int getChoice4() {
        return choices[3];
    }

    public int getChoice5() {
        return choices[4];
    }

    public void print() {
        System.out.println("Name: " + name + "\nID: " + id + "\nSessions: " + sessions[0] + ", " + sessions[1] + ", " + sessions[2] + ", " + sessions[3] + ", " + sessions[4]);
    }

}
