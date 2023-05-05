import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class myCSV{
    public static void main(String[]args) throws IOException{
        String data = "/Users/robertostagg/Desktop/SoftwareDeveloperSalaries.csv";
        String line = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(data)); 
            while ((line = file.readLine()) != null){ // Read through each line until a null value is found
                String[] values = line.split(","); // Break each line where there's commas into smaller strings, store into the values array
                System.out.printf("City:  %-50s | Salary Avg: %+1s\n", values[1], values[3]); //values[1] is left aligned by 50 characters
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}