import java.util.Scanner;

public class Lab72 {
   public static void main(String[] args) {
      //set-up
      Scanner scnr = new Scanner(System.in);
      double[] costList = {}; String costListString = "";
      String[] nameList = {}; String nameListString = "";
      
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
         
         nameListString += input + "SPLITHERE"; //make one long string
         
         //Cost
         System.out.print("\nPlease provide the cost of the expense: ");
         input = scnr.nextLine();
         costListString += input + "SPLITHERE"; //make one long string
      }
      
      System.out.println(); //formatting
      
      nameList = nameListString.split("SPLITHERE"); //string --> array (because i don't know how many items the user has!)
      
      String[] tempList = costListString.split("SPLITHERE"); //string --> array
      
      //String[] --> double[]
      costList = new double[tempList.length]; 
      for(int i = 0; i < tempList.length; i++){ 
         costList[i] = Double.parseDouble(tempList[i]);
      }
      
      //formatting (basically ensure the dollar signs align)
      int size = 0;
      for(String s : nameList){
         if(s.length() > size){size = s.length();}
      }      
      
      for(int i = 0; i < costList.length; i++){
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
