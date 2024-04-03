/**
 * Tester class of the Senior Seminar Program
 * Scans the files, helps assign each student, and asks for user input
 * 
 * @author kailyn0215
 */

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
        int[][] seshGrid = { //cols r rooms. 
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };
        int[] seshPopularity = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // the popularity of each session (graded based on # in peoples choices)
        int[] seshPeople = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // how many people wanted this in their top 5 choices
        boolean[] done = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        int[] topSesh = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //top # of sessions
        int[] whatCol = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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

        int[] choice = {0, 0, 0, 0, 0};

        int counter = 0;

        try { //try catch for students data table
            File students = new File("SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv");
            Scanner stuScanner = new Scanner(students);
            int count = 0;
            int id = 0;
            while (stuScanner.hasNextLine()) {
                String currentStudent[] = stuScanner.nextLine().split(",");
                tempTime = currentStudent[0];
                tempName = currentStudent[1];
                tempUser = currentStudent[2];

                //not sure if this whole thing will work how i want it to but its ok for now !!
                choice1 = Integer.parseInt(currentStudent[3]); //number 1 choice
                seshPopularity[choice1] = seshPopularity[choice1] + 5; //adds 5 to the session's popularity points
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
                    studentList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5, id)); // if they made any choices
                    for(int i = 0; i < 5; i++) {
                        for(int o = 0; o < 5; o++) {
                            while(seshGrid[i][o] == 0 && !done[choice1]) {
                                seshGrid[i][o] = choice1;
                                done[choice1] = true;
                                counter++;
                            }
                        }
                    }
                }
                else {
                    unassignedList.add(new Student(tempTime, tempName, tempUser, choice1, choice2, choice3, choice4, choice5, id)); // if they didnt make any choices NEED TO IMPLEMENT PUTTING THEM INTO THE LIST @ THE END
                }
                
                id++;
                count++;
            }
            //System.out.println("Finished student try catch for a total of " + (count) + " students.");
            stuScanner.close();
            for(int x = 0; x < 19; x++) {
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! It looks like one of the files hasn't been loaded in! Please load 'SeniorSeminarStudents.xlsx - SrSeminar_RawData.csv' into the program.");
            e.printStackTrace();
        }

        try { //try catch for sessions data table
            File sessions = new File("SeniorSeminarSessions.xlsx - Sheet1.csv");
            Scanner seshScanner = new Scanner(sessions);
            while (seshScanner.hasNextLine()) {
                String currentSession[] = seshScanner.nextLine().split(",");
                tempName = currentSession[0];
                tempId = Integer.parseInt(currentSession[1]);
                tempProctor = currentSession[2];
                sessionList.add(new Session(tempName, tempId, tempProctor, seshPopularity[tempId])); 
            }
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
                    alrDone = true;
                    break; // hopefully breaks out of placement loop?
                } 
            }
            if(!alrDone) {
                organizedList.add(i); //if it doesnt work then add it to the end of the list
            }
        }
        
        for(int add = 1; add <= 18; add++) { // keeps track of the current id
            search:
            for(int t = 0; t < 5; t++) {
                for(int r = 0; r < 5; r++) {
                    if(seshGrid[t][r] == 0 && !done[add] && seshPopularity[add] >= 10) { //if the grid is empty and if the id hasnt already been placed onto the grid
                        seshGrid[t][r] = add;
                        done[add] = true;
                        whatCol[add] = r;
                        counter++;
                    }
                    else if(seshPopularity[add] < 10) { //put this is bc i think cutting session #4 is the best idea, only 2 people chose it for lower choices
                        System.out.println("Session #" + add + " was unable to be added to the schedule due to lack of demand.");
                        break search; // had to figure out how to break out of the nested for loops to stop it from printing over and over again, this works in testing but im not sure if its the best way to go about it
                    }
                }
            }
        }

        for(int x = 0; x < 25 - counter; x++) { // the top how ever many sessions after cutting the less popular ones
            topSesh[x] = organizedList.get(x);
            sessionList.get(topSesh[x]).setDoubleSession(true);
        }

        for(int two = 0; two <= 25 - counter; two++) {
            doubles:
            for(int t = 0; t < 5; t++) {
                for(int r = 0; r < 5; r++) {
                    if(seshGrid[t][r] == 0 /*&& r != whatCol[topSesh[two]]*/) { //if the grid is empty, the other part isnt neccessary so i commented it out
                        seshGrid[t][r] = topSesh[two];
                        break doubles;
                    }
                }
            }
        }

        for(int r = 0; r < 5; r++) {
            System.out.print("Time slot " + (r + 1) + ": ");
            for(int c = 0; c < 5; c++) {
                System.out.print(seshGrid[r][c] + " ");
            }
            System.out.print("\n");
        }

        /*for(Student stu : studentList) {
        //for(int u = 0; u < studentList.size(); u++) {
            choice[0] = stu.getChoice1();
            choice[1] = stu.getChoice2();
            choice[2] = stu.getChoice3();
            choice[3] = stu.getChoice4();
            choice[4] = stu.getChoice5();
            for(int i = 0; i < 5; i++) {
                if(sessionList.get(choice[i] - 1).getPeople() < 16) {
                    sessionList.get(choice[i] - 1).setPeople();
                    sessionList.get(choice[i] - 1).setStudents(stu.getId());
                }
                else if(sessionList.get(choice[i] - 1).getDoubleSession() && sessionList.get(choice[i]).getPeople2() < 16) {
                    sessionList.get(choice[i] - 1).setPeople2();
                    sessionList.get(choice[i] - 1).setStudents2(stu.getId());
                }
                else {
                    for(int x = organizedList.size() - 1; x >= 0; x--) {
                        if(sessionList.get(x).getPeople() < 16) {
                            sessionList.get(x).setPeople();
                            sessionList.get(x).setStudents(stu.getId());
                        }
                    }
                }
            }
            stu.print();
            
        } */

        for(Student stu : studentList) {
            choice[0] = stu.getChoice1();
            choice[1] = stu.getChoice2();
            choice[2] = stu.getChoice3();
            choice[3] = stu.getChoice4();
            choice[4] = stu.getChoice5();

            for(int t = 0; t < 5; t++) { // for each time slot
                for(int r = 0; r < 5; r++) { // each room
                    for(int i = 0; i < 5; i++) { // each choice
                        if(seshGrid[t][r] == choice[i] && sessionList.get(choice[i]).getPeople() < 16) {
                            sessionList.get(choice[i]).setPeople();
                            sessionList.get(choice[i]).setStudents(stu.getId());
                        }
                    } 
                }
            }
        }

        // instructions for user
        System.out.println("Welcome to Senior Seminar!");

        while(true) { // when they r in the program continue
            System.out.println("Would you like to 1- Search by student, 2- Search by Session ID, 3- Print all of the students");
            Scanner in = new Scanner(System.in);
            int inp = Integer.parseInt(in.nextLine());

            if(inp == 1) { // NOT WORKING PROPERLY? (been trying to get it to work but there is something wrong w my computer + cant get things to run :( )
                System.out.println("Please enter the students USERNAME: ");
                String userName = in.nextLine();
                boolean found = false;
                for(int x = 0; x < studentList.size(); x++) {
                    if(studentList.get(x).getName() == userName) {
                        studentList.get(x).print();
                        found = true;
                    }
                    else if(!found) {
                        System.out.println("Looks like " + userName + " couldn't be found.");
                        break;
                    }
                }
            }
            else if(inp == 2) { // return students in specific sessions
                System.out.println("Please enter the session ID: \n(This will return the IDs of all of the students who are in this session)");
                int sessionID = Integer.parseInt(in.nextLine());
                if(sessionList.get(sessionID).getDoubleSession()) {
                    System.out.println("Session 1: ");
                    sessionList.get(sessionID).printStudents();
                    System.out.println("Session 2: ");
                    sessionList.get(sessionID).printStudents2();
                }
                
                // need to add a condition for if there is a second version of this session
            }
            else { // returns list of students
                for(Student p : studentList) {
                    p.print(); //not continuing to the students who didnt fill out form - they are in an unassigned list
                }
            } 
        }
        


    }
}
