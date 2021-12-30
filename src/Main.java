import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    Написати програму на мові Java, яка рекурсивно обробляє вказану/введену з
    клавіатури директорію згідно варіанту (таблиця), запускаючи для обробки кожної її
    піддиректорії окремий потік та використовуючи для цього можливості executors.

    Знайти у заданій директорії всі текстові файли та виконати сортування їхнього
    вмісту за зростанням. Відсортовані файли записати до нової директорії
     */
    public static void main(String[] args) throws IOException {

        Sorter sorter = new Sorter();

        String firstName = "/Users/max/Desktop/LabJava/Old/Java1.txt";
        String secondName = "/Users/max/Desktop/LabJava/Old/Java2.txt";
        String thirdName = "/Users/max/Desktop/LabJava/Old/Java3.txt";
        String fourthName = "/Users/max/Desktop/LabJava/Old/Java4.txt";

        String firstNewName = "/Users/max/Desktop/LabJava/New/Java1.txt";
        String secondNewName = "/Users/max/Desktop/LabJava/New/Java2.txt";
        String thirdNewName = "/Users/max/Desktop/LabJava/New/Java3.txt";
        String fourthNewName = "/Users/max/Desktop/LabJava/New/Java4.txt";

        File first = new File(firstName);
        File second = new File(secondName);
        File third = new File(thirdName);
        File fourth = new File(fourthName);


        try {
            first.createNewFile();
            second.createNewFile();
            third.createNewFile();
            fourth.createNewFile();

        }

        catch (IOException e){
            e.printStackTrace();
        }

        write(firstName);
        write(secondName);
        write(thirdName);
        write(fourthName);

        sorter.sort(new String[]{firstName, secondName, thirdName, fourthName},new String[]{firstNewName, secondNewName, thirdNewName, fourthNewName},0 );

    }

    public static void write(String filename){
        Random random = new Random();
        try{
            FileWriter fileWriter = new FileWriter(filename);
            for (int i = 0; i < 100; i++) {
                fileWriter.append(Integer.toString(random.nextInt(100))).append(" ");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
