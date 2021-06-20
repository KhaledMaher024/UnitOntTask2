/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author GP65
 */
public class SystemOperation {

    private static final LinkedList<StudentRecord> students = new LinkedList<>();

    public SystemOperation() {
        StudentRecord s1 = new StudentRecord(1202, 23, "Khaled", "Gaza_Palestine", "M", "Married", "0592496300", "11/03/1998");
        StudentRecord s2 = new StudentRecord(1201, 20, "Ali", "Syda_Lebanon", "M", "Single", "0595381955", "15/04/2001");
        StudentRecord s3 = new StudentRecord(1205, 21, "Ahmed", "Cairo_Eygpt", "M", "Single", "0599738130", "21/11/2000");
        addEntry(s1);
        addEntry(s2);
        addEntry(s3);

    }

    public int menu() {
        Scanner sc = new Scanner(System.in);
        int temp;
        System.out.printf("\n\t\t**********************************************");
        System.out.printf("\n\t\t*          STUDENT REGISTRATION PROGRAM      *");
        System.out.printf("\n\t\t**********************************************");
        System.out.printf("\n");
        System.out.printf("\n\t\t\t[1]Add New Student Record  ");
        System.out.printf("\n\t\t\t[2]Delete Student Record   ");
        System.out.printf("\n\t\t\t[3]Display Student Record  ");
        System.out.printf("\n\t\t\t[4]Modify Student Record   ");
        System.out.printf("\n\t\t\t[5]Search Student Record      ");
        System.out.printf("\n\t\t\t[6]Exit The Program              ");
        System.out.printf("\n\n\t\t\tPlease Enter Your Choice: ");
        temp = sc.nextInt();
        return temp;
    }

    void pass() {
        System.out.printf("\n\n\t\t\t  SCHOOL OF COMPUTING & TECHNOLOGY.");
        System.out.printf("\n\t\t\t  *********************************");
        System.out.printf("\n\t\t\t  *********************************\n");
        boolean valid = true;
        int retry = 1;
        String pass;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf("Enter The Password: ");
            pass = sc.next();
            if (!pass.equalsIgnoreCase("skm")) {
                System.out.printf("Incorrect Password!");
                valid = false;
                retry += 1;
            } else {
                valid = true;
            }
        } while (!valid && retry <= 3);

        if (retry > 3) {
            System.out.printf("Maximum 3 try only! Bye!");
            System.exit(0);
        } else {
            System.out.printf("Access approved!");
            while (true) {
                int choice = menu();
                process(choice);
            }
        }
    }

    public void process(int choice) {
        StudentRecord num;
        int ID;
        switch (choice) {
            case 1:
                num = getRecord();
                addEntry(num);
                System.out.printf("\n Record Inserted!");
                break;
            case 2:
                ID = getID();
                deleteEntry(ID);
                break;
            case 3:
                DisplayEntry();
                break;
            case 4:
                ID = getID();
                ModifyEntry(ID);
                break;
            case 5:
                ID = getID();
                SearchId(ID);
                break;
            case 6:
                System.out.printf("\n\n\t\t\t*******T H A N K  Y O U !!******");
                System.out.printf("\n\t\t\t******Done by : KAMRAN MEHDI****");
                System.out.printf("\n\t\t\t*******PROGRAM  TERMINATED******");
                break;
            default:
                System.out.printf("INVALID CHOICE!!! PLEASE ENTER AGAIN!");
        }
    }

    public boolean IsDuplicate(int temp) {
        StudentRecord tempStd = search(temp);
        if (tempStd != null) {
            System.out.printf("\n\t<<StudentID Number already in use !>>");
            System.out.printf("\n");
            return true;
        }

        return false;
    }

    public void addEntry(StudentRecord std) {
        if (std != null) {
            students.add(std);
        }
    }

    public void deleteEntry(int id) {
        StudentRecord temp = search(id);
        if (temp != null) {
            students.remove(temp);
        } else {
            System.out.printf("\n\t Sorry Record Does Not Exist!!");
            System.out.printf("\n\t Please PRESS any key to continue!!");
        }

    }

    public void DisplayEntry() {
        System.out.printf("\n\t\t*************************************************");
        System.out.printf("\n\t\t  *********DISPLAY STUDENT RECORD****************");
        System.out.printf("\n\t\t*************************************************");
        System.out.printf("\n");
        for (Iterator<StudentRecord> iterator = students.iterator(); iterator.hasNext();) {
            StudentRecord next = iterator.next();
            next.printInfo();
            System.out.println("------------------------------------------------------------------------------");

        }
    }

    public void DisplayRecord(StudentRecord std) {
        if (std.getStuID() != 0) {
            std.printInfo();
        }
    }

    public StudentRecord UpdateRecord(StudentRecord std) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\nChange Address [Y] >> ");
        char addchoice = sc.next().charAt(0);
        if (addchoice == 'Y' || addchoice == 'y') {

            System.out.printf("\nEnter new Address >> ");
            String updatedAdress = sc.next();
            std.setAddress(updatedAdress);
            System.out.printf("\nAddress Updated Successfully ");
        }
        System.out.printf("\nChange contact No >>[Y] ");
        char contactChoice = sc.next().charAt(0);
        if (contactChoice == 'Y' || contactChoice == 'y') {
            System.out.printf("\nEnter new contact No >> ");
            String updatedContact = sc.next();
            std.setCno(updatedContact);
            System.out.printf("\nContact Updated Successfully ");

        }
        return std;

    }

    public int getID() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("\nPlease Enter Student ID: ");
        int x = sc.nextInt();
        return x;
    }

    public StudentRecord search(int ID) {
        Optional<StudentRecord> result = students.stream().filter(x -> {
            if (x.getStuID() == ID) {
                return true;
            }
            return false;
        }).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public void ModifyEntry(int ID) {
        StudentRecord temp = search(ID);
        if (temp != null) {
            System.out.printf("\n\t\t*************************************************");
            System.out.printf("\n\t\t**********R E C O R D    F O U N D!!*************");
            System.out.printf("\n\t\t*************************************************");
            System.out.printf("\n");
            DisplayRecord(temp);
            temp = UpdateRecord(temp);
            return;
        }
        System.out.printf("Record does not exist!");
    }

    public void SearchId(int id) {
        StudentRecord temp = search(id);
        if (temp != null) {
            System.out.printf("\n\t\t*************************************************");
            System.out.printf("\n\t\t**********R E C O R D    F O U N D!!*************");
            System.out.printf("\n\t\t*************************************************");
            System.out.printf("\n");
            DisplayRecord(temp);
        } else {
            System.out.printf("\n\t Sorry Record Does Not Exist!!");
            System.out.printf("\n\t Please PRESS any key to continue!!");
        }

    }

    public int isEmpty() {
        if (students == null || students.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public StudentRecord getRecord() {
        Scanner sc = new Scanner(System.in);
        StudentRecord temp = new StudentRecord();
        System.out.printf("\n\t\t******************************************");
        System.out.printf("\n\t\t*********ADD NEW STUDENT RECORD***********");
        System.out.printf("\n\t\t******************************************");
        System.out.printf("\n");
        System.out.println("\t Student ID: ");
        String stdId = sc.next();
        temp.setStuID(getCode(stdId));
        System.out.println("\t Student : ");

        temp.setName(getString("\t  Student Name:", 30, 1));

        do {
            temp.setAddress(getString("\t  Student address:"));
            if (temp.getAddress().length() < 10) {
                System.out.printf("\t\t<< Address should not be Empty or \n\t\tIt should not less than 10 characters >>\n");
            }
        } while (temp.getAddress().length() < 10);

        temp.setGender(getString("\t  Student Gender [F or M]:", 1, 0));

        do {
            Scanner sc2 = new Scanner(System.in);
            System.out.printf("\t  Student Age:");

            temp.setAge(sc.nextInt());

            if ((temp.getAge()) < 3) {
                System.out.printf("\t  <<Student age should not be Empty or \n\t\tIt should not more than 2 character>>\n");
            }
        } while ((temp.getAge()) < 3);

        temp.setCno(getString("\t  Student Contact No:", 10, 2));

        do {
            temp.setStatus(getString("\t  Marital Status:"));

            if (temp.getStatus().length() > 10) {
                System.out.printf("\t\t<<Marital Status should not be Empty or \n\t\tIt should not exceed 10 characters>>\n");
            }
        } while (temp.getStatus().length() > 10);

        temp.setDate(getDate());

        System.out.printf("\n\tPlease Press any key to continue!!");
        return temp;
    }

    public int getCode(String temp) {
        Scanner sc = new Scanner(System.in);
        boolean OK;
        do {
            OK = true;
            if (temp.length() != 4) {
                System.out.printf("\t\t<< Student ID should not be Empty or It should \n\t\t only 4 digits >>\n");
                OK = false;
            }
            for (int count = 0; count < temp.length(); count++) {
                if (!isDigit(temp.charAt(count) + "")) {
                    System.out.printf("\t\t<< Must be digits! >>\n");
                    OK = false;
                }
                break;
            }
        } while (!OK || IsDuplicate(Integer.parseInt(temp)));
        return Integer.parseInt(temp);
    }

    public boolean isDigit(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String getString(String str) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("%s", str);
        String temp = sc.next();
        return temp;
    }

    public String getString(String str, int size, int status) {
        Scanner sc = new Scanner(System.in);
        String temp;
        boolean OK;
        do {

            OK = true;
            System.out.printf("%s", str);

            temp = sc.next();
            if (temp.length() > size) {
                System.out.printf("\t\t<< Contact No should not be Empty or \n\t\t It should not exceed %d characters! >>\n", size);
                OK = false;
            }
            if (status == 1 && temp.length() < 4) {
                System.out.printf("\t\t<< Name should not be Empty or \n\t\t It should not less than 4 characters.>>\n");
                OK = false;
                for (int count = 0; temp.charAt(count) != '\0'; count++) {
                    String s = temp.charAt(count) + "";
                    if (!s.matches("^[a-zA-Z0-9]*$")) {
                        System.out.printf("\t\t<< Student Name Must be characters! >>\n");
                        OK = false;
                    }
                    break;
                }
            }
            if (status == 2) {
                if (temp.length() < 8) {
                    System.out.printf("\t\t<<Contact No should not be Empty or \n\t\tIt should not less than 8 characters>>\n");
                    OK = false;
                } else {
                    for (int count = 0; count < temp.length(); count++) {
                        if (!isDigit(temp.charAt(count) + "")) {
                            System.out.printf("\t\t<< Contact No Must be numeric!>>\n");
                            OK = false;
                            break;
                        }
                    }
                }
            }

            if (status == 0 && (temp.charAt(0) != 'm' && temp.charAt(0) != 'f')) {
                System.out.printf("\t\t<< Gender should not be Empty or \n\t\t It should be only M or F >>\n");
                OK = false;

            }
        } while (!OK);
        return temp;
    }

    public String getDate() {
        boolean OK;
        String temp;
        Scanner sc = new Scanner(System.in);
        do {
            OK = true;
            System.out.printf("\t  Student D.O.B [DD/MM/YYYY]:");
            temp = sc.next();

            if (temp.length() != 10) {
                System.out.printf("\t\t<< Student D.O.B should not be Empty or \n\t\t It should Must be 10 characters >>\n");
                OK = false;
            } else if (!isDigit(temp.charAt(0) + "") || !isDigit(temp.charAt(1) + "") || !isDigit(temp.charAt(3) + "") || !isDigit(temp.charAt(4) + "")
                    || !isDigit(temp.charAt(6) + "") || !isDigit(temp.charAt(7) + "") || !isDigit(temp.charAt(8) + "") || !isDigit(temp.charAt(9) + "")
                    || temp.charAt(2) != '/' || temp.charAt(5) != '/') {
                System.out.printf("\t\t<< Student D.O.B Format must be dd/mm/yyyy >>\n");
                OK = false;
            } else if (temp.charAt(0) < '0' || temp.charAt(0) > '3') {
                System.out.printf("\t\t<< Invalid day >>\n ");
                OK = false;
            } else if (temp.charAt(3) < '0' || temp.charAt(3) > '1' || temp.charAt(4) < '0' || temp.charAt(4) > '9') {
                System.out.printf("\t\t<< Invalid month >> \n");
                OK = false;
            } else if (temp.charAt(6) < '1' || temp.charAt(6) > '2') {
                System.out.printf("\t\t<< Invalid year >>\n ");
                OK = false;
            }
        } while (!OK);
        return temp;
    }

}
