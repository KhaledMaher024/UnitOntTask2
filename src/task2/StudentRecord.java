/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.time.LocalDate;

/**
 *
 * @author GP65
 */
public class StudentRecord {

    private int StuID;
    private int age;
    private String name;
    private String address;
    private String gender;
    private String status;
    private String cno;
    private String date;

    public StudentRecord() {
    }

    public StudentRecord(int StuID, int age, String name, String address, String gender, String status, String cno, String date) {
        this.StuID = StuID;
        this.age = age;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.status = status;
        this.cno = cno;
        this.date = date;
    }

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int StuID) {
        this.StuID = StuID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void printInfo() {
        System.out.printf("\n\tStudent ID          :%d", StuID);
        System.out.printf("\n\tName                 :%s", name);
        System.out.printf("\n\tAddress              :%s", address);
        System.out.printf("\n\tGender               :%s", gender);
        System.out.printf("\n\tStatus               :%s", status);
        System.out.printf("\n\tAge                  :%d", age);
        System.out.printf("\n\tContact Number         :%s", cno);
        System.out.printf("\n\tStudent D.O.B       :%s ", date);
    }
}
