import java.util.*;
public class DistanceFromAverage
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      double[] numbers;
      int enteredSize = 0, x = 0, y;
      double entry = 0, total = 0, average= 0;
      final int QUIT = 99999;
      boolean canCreateArray = true, isValOk = false;

      try { // check if integer
         System.out.print("Please enter a value for the array size >> ");
         enteredSize = input.nextInt();
      } catch(InputMismatchException  e) {
         System.out.println("Invalid value for array size");
         canCreateArray = false;
         input.nextLine();
      }

      if(canCreateArray) { // confirm is integer
         try { // check if is negative
            numbers = new double[enteredSize];
         } catch(NegativeArraySizeException e) {
            System.out.println("Negative array size");
            input.nextLine();
            enteredSize = 5;
            numbers = new double[enteredSize];
         }

         while(!isValOk) { // check if is double
             try {
                 System.out.print("Enter a numeric value or " +
                    QUIT + " to quit >> ");
                 entry = input.nextDouble();
                 isValOk = true;
             } catch(NumberFormatException e) {
                isValOk = false;
                input.nextLine();
             }
         }

         while(entry != QUIT && x < numbers.length) { // check if entry == quit and array populated
            numbers[x] = entry;
            ++x;
            if(x < numbers.length) {
               try {
                  System.out.print("Enter next numeric value or " +
                     QUIT + " to quit >> ");
                  entry = input.nextDouble();
               }
               catch(NumberFormatException e) {
                  --x;
                  input.nextLine();
               }
            }
         }

         // if array size is not 0
         if(x == 0) System.out.println("Average cannot be computed because no numbers were entered");
         else {
            for (double number : numbers) total += number;
            average = total / x;
            System.out.println("You entered " + x +
               " numbers and their average is " + average);

            for(y = 0; y < x; ++y)
               System.out.println(numbers[y] + " is " +
                  (average - numbers[y]) + " away from the average");
         }           
      }
   }
}
