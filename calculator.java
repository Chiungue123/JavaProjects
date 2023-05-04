import java.util.Scanner;

public class calculator{
  public static void main(String[] args){
     // Prompt the first number
  Scanner number = new Scanner(System.in);
  System.out.println("Enter the first number: ");
  int number1 = number.nextInt();

  // Prompt the operator
  System.out.println("Enter the operator(+, -, x, %): ");
  String operator = number.next();

  // Prompt the second number
  System.out.println("Enter the second number: ");
  int number2 = number.nextInt();
  number.close();

  // Check which operator is used, then use the appropriate calculation

  int result = 0;
  if (operator.equals("+")){
      result = number1 + number2;
  }

  else if(operator.equals("-")){
      result = number1 - number2;
  }

  else if (operator.equals("x")){
      result = number1 * number2;
  }

  else if (operator.equals("%")){
      result = number1/number2;
  }

  // Return the calculation
  System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
  }
}