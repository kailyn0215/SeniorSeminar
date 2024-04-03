/**
 * holds information about each session + allows Tester to print information when neccessary
 * 
 * @author kailyn0215
 */

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

    /**
     * assigns the params into usable variables
     * 
     * @param seshName the name of the session
     * @param seshId the ID of the session
     * @param seshProctor the proctor of the session
     * @param seshPopularity the popularity of the session
     */
    public Session(String seshName, int seshId, String seshProctor, int seshPopularity) {
        name = seshName;
        id = seshId;
        proctor = seshProctor;
        popularity = seshPopularity;
        //System.out.println("Added " + name + ", ID: " + id + ", Proctored by " + proctor);
    }

    /**
     * assigns the param sesh id in case of a second session
     * 
     * @param seshId the ID of the session
     */
    public Session(int seshId) {
        id = seshId;
    }

    /**
     * @return the name of the session
     */
    public String getName() {
        return name;
    }

    /**
     * @return the proctor of the session
     */
    public String getProctor() {
        return proctor;
    }

    /**
     * sets the popularity of the session later on
     * @param pop the popularity of the session
     */
    public void setPopularity(int pop) {
        popularity = pop;
    }

    /**
     * @return the popularity of the session
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * @return the id of the session
     */
    public int getID() {
        return id;
    }

    /**
     * @return the # of people in the session
     */
    public int getPeople() {
        return people;
    }

    /**
     * adds one person to the session
     */
    public void setPeople() {
        people++;
    }

    /**
     * @param id the id of the student being added
     */
    public void setStudents(int id) {
        students.add(id);
    }

    /**
     * prints the list of students in this session
     */
    public void printStudents() {
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }  
    }

    /**
     * @return if there are two sessions or not
     */
    public boolean getDoubleSession() {
        return twice;
    }

    /**
     * @param set lets the program know if it should set the session to double or not
     */
    public void setDoubleSession(boolean set) {
        twice = set; 
    }

    /**
     * @return the number of peopel in the second session
     */
    public int getPeople2() {
        return people2;
    }

    /**
     * adds a person to the second session
     */
    public void setPeople2() {
        people2++;
    }

    /**
     * @param id the id of the student getting added into the second session
     */
    public void setStudents2(int id) {
        students2.add(id);
    }

    /**
     * prints the list of the second session if applicable
     */
    public void printStudents2() {
        for(int i = 0; i < students2.size(); i++) {
            System.out.println(students2.get(i));
        } 
    }

}
