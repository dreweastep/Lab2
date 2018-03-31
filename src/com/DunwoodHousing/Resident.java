package com.DunwoodHousing;

import java.io.*;


abstract class Resident implements Serializable {

    String residentType;

    String IDNumber;

    String firstName;

    String lastName;

    String roomNumber;

    String floorNumber;

    double monthlyRent;
}