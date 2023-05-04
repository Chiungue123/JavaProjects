import java.util.ArrayList;
import java.util.Scanner;


public class todo{
  public static void main(String[]args) throws InterruptedException{
      Scanner input = new Scanner(System.in);
      ArrayList<String> todo = new ArrayList<String>();
      while (true){
          // Prompt the user to add, remove, edit or quit the program
          System.out.println("A - Add task: \nR - Remove task: \nV - View tasks\nE - Edit task: \nQ - Quit program");
          String prompt = input.next();


          // Allows the user to add a task
          if (prompt.toLowerCase().equals("a")){
              // Todo
            }
            // User can remove tasks
            else if (prompt.toLowerCase().equals("r")){
             // Todo

            }
            // Allow the user to view the tasks
            else if (prompt.toLowerCase().equals("v")){
               // Too
            }
            // User can edit a task
            else if (prompt.toLowerCase().equals("e")){
            // Todo
            }
            // Allows to quit the program
            else if (prompt.toLowerCase().equals("q")){
        
            System.out.println("You are quitting the program.");
            System.exit(0);
        }
    }
}
}