import java.util.Scanner;

public class Lab72 {
   public static void main(String[] args) {
      //set-up
      Scanner scnr = new Scanner(System.in); int length = 0;
      double[] costList = new double[100];
      String[] nameList = new String[100];
      
      //intro
      System.out.println("Welcome! When inputting costs please put them in normal format but without the dollar sign.");
      System.out.println("Examples of acceptable data: -40.20, 3223, 5.9312, 00.000, -2");
      
      //user input
      String input = null;
      while(scnr.hasNext() && input != ""){
         //Name
         System.out.print("\nPlease provide the name of the expense: ");
         input = scnr.nextLine();
         
         if(input.equals("")){break;} //exit
         if(!scnr.hasNext()){break;}
         
         nameList[length] = input;
         
         //Cost
         System.out.print("\nPlease provide the cost of the expense: ");
         costList[length] = Double.parseDouble(scnr.nextLine());
         length += 1;
         if(length == 100){break;}
      }
      
      System.out.println(); //formatting
      
      //formatting (basically ensure the dollar signs align)
      int size = 0;
      for(int i = 0; i < length; i++){String s = nameList[i];
         if(s.length() > size){size = s.length();}
      }      
      
      for(int i = 0; i < length; i++){
         System.out.print(nameList[i]); //print name
         
         //formatting
         for(int space = 0; space < size - nameList[i].length(); space++){
            System.out.print(" ");
         }
         System.out.print("\t");
         
         //print cost
         System.out.print("$ ");
         if(costList[i] < 0){ System.out.print("(");} else{System.out.print(" ");}
         System.out.printf("%7.2f", Math.abs(costList[i]));   
         if(costList[i] < 0){ System.out.println(")");} else{System.out.println();}
      }
      
   }
}
