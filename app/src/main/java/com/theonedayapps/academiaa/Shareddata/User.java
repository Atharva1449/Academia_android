package com.theonedayapps.academiaa.Shareddata;

import java.util.Date;

public class User {
   private String Roll_no,Degree,Department,Year_admission,Name,Semester,Section_name,Father_name,Mother_name,Guardian_name,Dob,Blood_group,Caste,category,Religion,Adhar_no,Address,Email,Phone_no1,Phone_no2,Phone_no3;

    public User(String roll_no, String degree, String department, String year_admission, String name, String semester, String section_name, String father_name, String mother_name, String guardian_name, String dob, String blood_group, String caste, String category, String religion, String adhar_no, String address, String email, String phone_no1, String phone_no2, String phone_no3) {
        Roll_no = roll_no;
        Degree = degree;
        Department = department;
        Year_admission = year_admission;
        Name = name;
        Semester = semester;
        Section_name = section_name;
        Father_name = father_name;
        Mother_name = mother_name;
        Guardian_name = guardian_name;
        Dob = dob;
        Blood_group = blood_group;
        Caste = caste;
        this.category = category;
        Religion = religion;
        Adhar_no = adhar_no;
        Address = address;
        Email = email;
        Phone_no1 = phone_no1;
        Phone_no2 = phone_no2;
        Phone_no3 = phone_no3;
    }
}
