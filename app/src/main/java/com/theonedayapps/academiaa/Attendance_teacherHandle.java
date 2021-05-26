package com.theonedayapps.academiaa;

public class Attendance_teacherHandle {
private String Name;
private String Rollno;

    public Attendance_teacherHandle(){}
    public Attendance_teacherHandle(String name, String rollno) {
        Name = name;
        Rollno = rollno;
    }

    public String getNameteacherhandle() {
        return Name;
    }

    public void setNameteacherhandle(String name) {
        Name = name;
    }

    public String getRollno() {
        return Rollno;
    }

    public void setRollno(String rollno) {
        Rollno = rollno;
    }
}
