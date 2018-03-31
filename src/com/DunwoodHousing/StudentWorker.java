package com.DunwoodHousing;

import java.io.*;

public class StudentWorker extends Resident implements Serializable{

    private int monthlyHours;

    public StudentWorker(String id, String fname, String lname,
                         String roomNum, String floorNum, int hours){
        residentType = "Student Worker";
        IDNumber = id;
        firstName = fname;
        lastName = lname;
        roomNumber = roomNum;
        floorNumber = floorNum;
        monthlyHours = hours;
        monthlyRent = 1245 - ((monthlyHours * 14) / 2);
    }
}
