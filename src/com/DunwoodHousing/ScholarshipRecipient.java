package com.DunwoodHousing;

import java.io.*;

public class ScholarshipRecipient extends Resident implements Serializable{


    public ScholarshipRecipient(String id, String fname, String lname,
                          String roomNum, String floorNum){
        residentType = "Scholarship Recipient";
        IDNumber = id;
        firstName = fname;
        lastName = lname;
        roomNumber = roomNum;
        floorNumber = floorNum;
        monthlyRent = 100;
    }
}
