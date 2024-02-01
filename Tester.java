import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Student> unassignedList = new ArrayList<Student>();
        ArrayList<Session> sessionList = new ArrayList<Session>();
        //ArrayList<Session> organizedList = new ArrayList<Session>(); // maybe want to change this into integers to simplify?
        ArrayList<Integer> organizedList = new ArrayList<Integer>();
        int[] seshPopularity = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // the popularity of each session (graded based on # in peoples choices)
        int[] seshPeople = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // how many people wanted this in their top 5 choices
        boolean[] seshDouble = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}; // true if session is in top 7 (meaning they get a second )
        int[] topSesh = {0, 0, 0, 0, 0, 0, 0}; //top 7 sessions
        int temp = 0;
 
        String tempName; //temporary name holder for sessions/students
        int tempId; //temporary id for sessions
        String tempProctor; //temporary proctor name for sessions
        String tempTime; //temporary time for students
        String tempUser; //temporary username for students
        int choice1; //temporary students choices
        int choice2;
        int choice3;
        int choice4;
        int choice5;

        try { //try catch for students data table
            File students = new File("SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv");
            Scanner stuScanner = new Scanner(students);
            int count = 0;
            while (stuScanner.hasNextLine()) {
                String currentStudent[] = stuScanner.nextLine().split(",");
                tempTime = currentStudent[0];
                tempName = currentStudent[1];
                tempUser = currentStudent[2];

                //not sure if this whole thing will work how i want it to but its ok for now !!
                choice1 = Integer.parseInt(currentStudent[3]); //number 1 choice
                seshPopularity[choice1] = seshPopularity[choice1] + 5; //adds 5 to the session's popularity points
                //System.out.println("added 5 to session " + choice1 + "'s popularity");
                seshPeople[choice1] = seshPeople[choice1] + 1;

                choice2 = Integer.parseInt(currentStudent[4]); //2
                seshPopularity[choice2] = seshPopularity[choice2] + 4;
                seshPeople[choice1] = seshPeople[choice1] + 1;

                choice3 = Integer.parseInt(currentStudent[5]); //3
                seshPopularity[choice3] = seshPopularity[choice3] + 3;
                seshPeople[choice1] = seshPeople[choice1] + 1;

                choice4 = Integer.parseInt(currentStudent[6]); //4
                seshPopularity[choice4] = seshPopularity[choice4] + 2;
                seshPeople[choice1] = seshPeople[choice1] + 1;

                choice5 = Integer.parseInt(currentStudent[7]); //5
                seshPopularity[choice5] = seshPopularity[choice5] + 1;
                seshPeople[choice1] = seshPeople[choice1] + 1;

                if(choice1 > 0) {
                    studentList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5)); // if they made any choices
                }
                else {
                    unassignedList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5)); // if they didnt make any choices NEED TO IMPLEMENT PUTTING THEM INTO THE LIST @ THE END
                }
                
                count++;
            }
            //System.out.println("Finished student try catch for a total of " + (count) + " students.");
            stuScanner.close();
            for(int x = 0; x < 19; x++) {
                System.out.println("Session " + (x) + " has a popularity of " + seshPopularity[x]);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv' into the program.");
            e.printStackTrace();
        }

        try { //try catch for sessions data table
            File sessions = new File("SeniorSeminarSessions.xlsx - Sheet1.csv");
            Scanner seshScanner = new Scanner(sessions);
            int count = 0;
            while (seshScanner.hasNextLine()) {
                String currentSession[] = seshScanner.nextLine().split(",");
                tempName = currentSession[0];
                tempId = Integer.parseInt(currentSession[1]);
                tempProctor = currentSession[2];
                sessionList.add(new Session(tempName, tempId, tempProctor, seshPopularity[tempId], seshPeople[tempId])); // need to add something to get rid of something with little popularity (session 4 haha)
                count++;
            }
            //System.out.println("Finished session try catch for a total of " + (count) + " sessions.");
            seshScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarSessions.xlsx - Sheet1.csv' into the program.");
            e.printStackTrace();
        }

        // organizes the sessions based on their popularity
        organizedList.add(1);
        for(int i = 2; i < 19; i++) {//starts at 2 to continue through the rest of the possible sessions
            boolean alrDone = false;
            for(int o = 0; o < organizedList.size(); o++) { //goes through the length of the organized sessions to find where it fits
                if(seshPopularity[i] > seshPopularity[organizedList.get(o)] && !alrDone) {
                    organizedList.add(o, i); // adds the id of the session at the organized spot
                    System.out.println("Session ID " + i + " placed in spot " + o);
                    alrDone = true;
                    break; // hopefully breaks out of o loop?
                } 
            }
            if(!alrDone) {
                organizedList.add(i); //if it doesnt work then add it to the end of the list
                System.out.println("Session ID " + i + " added to end.");
            }
        }

        /* for(int e = 0; e < organizedList.size(); e++) {
            System.out.println(organizedList.get(e));
        } */
    }
}