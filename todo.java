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
                    Thread.sleep(2000);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }

            // User can remove tasks
            else if (prompt.toLowerCase().equals("r")){
                System.out.println("List of tasks");
                for (int j = 0; j < todo.size(); j++){
                    System.out.println((j+1) + ": " + todo.get(j));
                }

                System.out.println("Delete: ");
                String remove = input.next();

                for  (int i = 0; i < todo.size(); i++)
                {
                    if (todo.get(i).equals(remove))
                    {
                        todo.remove(i);
                        System.out.println(remove + " has been removed.");
                        Thread.sleep(2000);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                }
            }

            // Allow the user to view the tasks
            else if (prompt.toLowerCase().equals("v")){
                System.out.println("List of tasks");
                for (int j = 0; j < todo.size(); j++){
                    System.out.println((j+1) + ": " + todo.get(j));
                }
                Thread.sleep(3000);
                boolean isValid = false;
                while (!isValid){
                    System.out.println("R - Return to main menu\nQ - Quit program");
                    String menu = input.next().toLowerCase();
                    switch (menu){
                        // This switch statement evaluates the menu expression and executes code blocks based on matching cases
                        case "r":
                        // Return to main
                        isValid = true;
                        System.out.println("Returning to main menu");
                        Thread.sleep(2000);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;

                        case "q":
                        // Quit program
                        System.out.println("You are quitting the program.");
                        Thread.sleep(1000);
                        System.exit(0);

                        default: 
                        // Executes when the two cases above didn't match
                        System.out.println("Invalid input, please try again");
                        break;
                    }
                }
            }

            // User can edit a task
            else if (prompt.toLowerCase().equals("e")){
                boolean isValid = false; 
                while (!isValid){
                    System.out.println("List of tasks");
                    for (int j = 0; j < todo.size(); j++){
                        System.out.println((j+1) + ": " + todo.get(j));
                    } 

                    System.out.println("Name of task to edit");
                    String oldName = input.next();
                    for (int i = 0; i < todo.size(); i++){
                        if (todo.get(i).equals(oldName)){
                            System.out.println("New task name: ");
                            String newName = input.next();
                            System.out.println("Are you sure you want to rename " + oldName + " to " + newName + "?(y/n)");
                            String confirm = input.next().toLowerCase();
                            if (confirm.equals("y")){
                                todo.set(i, newName);
                                System.out.println("Task successfully renamed to " + newName);
                                Thread.sleep(2000);
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                isValid = true;
                            }
                        }
                    }
                    if (!isValid){
                        System.out.println("The task " + oldName + " wasn't found. Enter a valid task name.");
                        Thread.sleep(3000);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                }
            }

            // Allows to quit the program
            else if (prompt.toLowerCase().equals("q")){
            System.out.println("You are quitting the program.");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.exit(0);
        }
    }
}
}