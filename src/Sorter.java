import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Executor;

public class Sorter extends Thread {
    public void sort(String[] fileNames,String[] newFileNames, int counter)  {
        if (counter==4)
            return;
        Runnable task = () -> {
            int [] numbers = null;
            try (BufferedReader in = new BufferedReader(new FileReader(fileNames[counter])))
            {
                numbers = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            catch (IOException | NumberFormatException e)
            {
                e.printStackTrace();
            }
            boolean isSorted = false;
            int buf;
            while (!isSorted){
                isSorted = true;
                for (int i = 0; i < (numbers != null ? numbers.length : 0) -1; i++) {
                    if(numbers[i] > numbers[i+1]){
                        isSorted = false;

                        buf = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = buf;
                    }
                }
            }

            try{
                FileWriter fileWriter = new FileWriter(newFileNames[counter]);
                fileWriter.write
                        (Arrays.toString(numbers));
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        };
        Executor executor = (runnable) -> new Thread(runnable).start();
        executor.execute(task);
        sort(fileNames,newFileNames,counter+1);
    }

}
