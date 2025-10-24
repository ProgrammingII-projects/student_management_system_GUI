package utils;

import java.util.Random;

public class Generator {
    public static int generateStudentRandomId() {
         Random rand = new Random();
        int randomNum = rand.nextInt(1000000, 99999999);
        return randomNum;
    }
}