/**
 * Holds information about each student and allows Tester to print the info when neccessary
 * 
 * @author kailyn0215
 */

public class Student {

    private String time;
    private String name;
    private String user;
    private int[] choices = {0, 0, 0, 0, 0};
    private int[] sessions = {0, 0, 0, 0, 0};
    private int id;

    /**
     * assigns the params into usable variables
     * 
     * @param stuTime the time that the student filled out the form
     * @param stuName the name of the student
     * @param stuUser the username of the student
     * @param stuChoice1 the students #1 choice
     * @param stuChoice2 the students #2 choice
     * @param stuChoice3 the students #3 choice
     * @param stuChoice4 the students #4 choice
     * @param stuChoice5 the students #5 choice
     * @param stuId the students ID
     */
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

    /**
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * @return the user of the student
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the id of the student
     */
    public int getId() {
        return id;
    }

    /**
     * sets the sessions into time slots
     * 
     * @param timeSlot the targetted time slot
     * @param seshID the id of the session being implemented
     */
    public void setSesh(int timeSlot, int seshID) {
        sessions[timeSlot] = seshID;
    }

    /**
     * @param timeSlot the targetted time slot
     * @return the session in the specified time slot
     */
    public int getSesh(int timeSlot) {
        return sessions[timeSlot];
    }

    /**
     * @return #1 choice
     */
    public int getChoice1() {
        return choices[0];
    }

    /**
     * @return #2 choice
     */
    public int getChoice2() {
        return choices[1];
    }

    /**
     * @return #3 choice
     */
    public int getChoice3() {
        return choices[2];
    }

    /**
     * @return #4 choice
     */
    public int getChoice4() {
        return choices[3];
    }

    /**
     * @return #5 choice
     */
    public int getChoice5() {
        return choices[4];
    }

    /**
     * prints out the specified students information
     */
    public void print() {
        System.out.println("Name: " + name + "\nID: " + id + "\nSessions: " + sessions[0] + ", " + sessions[1] + ", " + sessions[2] + ", " + sessions[3] + ", " + sessions[4]);
    }

}
