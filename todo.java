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
              System.out.println("Enter the name of the task below");
              String task = input.next();
              boolean duplicate = false;
              for (int i = 0; i < todo.size(); i++){
                  if (todo.get(i).equals(task)){
                      duplicate = true;
                      break;
                  }
              }
              // Checking for duplicates
              if (duplicate){
                  System.out.println(task + " already exists in your list.");
                  Thread.sleep(2000);
                  System.out.print("\033[H\033[2J");
                  System.out.flush();


                }
                // Add task if no duplicates were found
                else{
                    todo.add(task);
                    System.out.println("The tasked called " + task + " has been added");
                }
            }
            
            // User can remove tasks
            else if (prompt.toLowerCase().equals("r")){
                // Todo
            }

            // Allow the user to view the tasks
            else if (prompt.toLowerCase().equals("v")){
               // Todo
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
