package utils;

import java.util.Random;

public class Generator {
    public static int generateStudentRandomId() {
         Random rand = new Random();
        int randomNum = rand.nextInt(10000, 99999);
        return randomNum;
    }
}