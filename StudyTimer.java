package Project;

import java.io.*;
import java.time.*;
import java.util.*;

public class StudyTimer {

    static Scanner sc = new Scanner(System.in);
    static LocalTime startTime;

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n1. Start Study\n2. Stop Study\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startStudy();
                    break;
                case 2:
                    stopStudy();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    static void startStudy() {
        startTime = LocalTime.now();
        System.out.println("Study started at: " + startTime);
    }

    static void stopStudy() throws IOException {
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("Study ended at: " + endTime);
        System.out.println("Duration: " + duration.toMinutes() + " minutes");

        saveToFile(duration.toMinutes());
    }

    static void saveToFile(long minutes) throws IOException {
        FileWriter fw = new FileWriter("study_log.txt", true);
        fw.write("Studied: " + minutes + " minutes\n");
        fw.close();
    }
}