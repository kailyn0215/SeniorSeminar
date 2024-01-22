public class Student {

    private String time;
    private String name;
    private String user;
    private int[] choices = {0, 0, 0, 0, 0};

    public Student(String stuTime, String stuName, String stuUser, int stuChoice1, int stuChoice2, int stuChoice3, int stuChoice4, int stuChoice5) {
        time = stuTime;
        name = stuName;
        user = stuUser;
        choices[0] = stuChoice1;
        choices[1] = stuChoice2;
        choices[2] = stuChoice3;
        choices[3] = stuChoice4;
        choices[4] = stuChoice5;

        System.out.println("Added " + name + " to the roster.");
    }
}
