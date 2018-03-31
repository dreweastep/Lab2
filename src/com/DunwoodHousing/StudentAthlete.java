package com.DunwoodHousing;

import java.io.*;

public class StudentAthlete extends Resident implements Serializable{


    public StudentAthlete(String id, String fname, String lname,
                         String roomNum, String floorNum){
        residentType = "Student Athlete";
        IDNumber = id;
        firstName = fname;
        lastName = lname;
        roomNumber = roomNum;
        floorNumber = floorNum;
        monthlyRent = 1200;
    }
}
