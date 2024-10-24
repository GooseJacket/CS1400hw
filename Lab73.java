import java.util.Scanner;

public class LabProgram {
   public static void printOut(String name, double cost, int size, boolean writeSign){
      System.out.print(name); //print name
         
      //formatting
      for(int space = 0; space < size - name.length(); space++){
         System.out.print(" ");
      }
      System.out.print("\t");
      
      //print cost
      System.out.print("$ ");
      if(cost < 0){ System.out.print("(");} else{System.out.print(" ");}
      if(writeSign){System.out.printf("%8.2f", cost);}
      else{System.out.printf("%8.2f", Math.abs(cost)); 
      }
      if(cost < 0){ System.out.println(")");} else{System.out.println();}
   }
   
   
   public static void main(String[] args) {
      //set-up
      Scanner scnr = new Scanner(System.in);
      double[] costList = {}; String costListString = "";
      String[] nameList = {}; String nameListString = "";
      
      //intro
      System.out.println("Welcome! When inputting costs please put them in normal format but without the dollar sign.");
      System.out.println("Examples of acceptable data: -40.20, 3223, 5.9312, 00.000, -2");
      
      //user input
      String name = null; String cost = "";
      while(scnr.hasNext() && name != ""){
         boolean madeSense = true;
         
         //Name
         System.out.print("\nPlease provide the name of the expense: ");
         name = scnr.nextLine();
         
         if(name.equals("")){break;} //exit
         
         
         
         //Cost
         System.out.print("\nPlease provide the cost of the expense: ");
         try{cost = scnr.nextLine(); Double.parseDouble(cost);}
         catch(Exception e){
            try{
               System.out.print("\nHey, that didn't make sense. Try the cost again?");
               cost = scnr.nextLine();
               Double.parseDouble(cost);
            }
            catch(Exception f){ 
               System.out.print("\nI really don't understand so I'm going to move on.");
               madeSense = false;
         }  }
         if(madeSense){
            nameListString += name + "SPLITHERE"; //make one long string
            costListString += cost + "SPLITHERE"; //make one long string
         }
      }
      
      System.out.println("\n"); //formatting
      
      nameList = nameListString.split("SPLITHERE"); //string --> array (because i don't know how many items the user has!)
      
      String[] tempList = costListString.split("SPLITHERE"); //string --> array
      
      //String[] --> double[]
      costList = new double[tempList.length]; 
      for(int i = 0; i < tempList.length; i++){ 
         costList[i] = Double.parseDouble(tempList[i]);
      }
      
      //formatting (basically ensure the dollar signs align)
      int size = "Subtotal:".length();
      for(String s : nameList){
         if(s.length() > size){size = s.length();}
      }      
      
      double income = 0.0; System.out.println("Income:"); //setup income
      for(int i = 0; i < costList.length; i++){if(costList[i] >= 0){
         income += costList[i];
         
         printOut(nameList[i], costList[i], size, false); //see top of page
         
      }}
      printOut("Subtotal:", income, size, true);
      
      System.out.println(); //formatting
      double expenses = 0.0; System.out.println("Expenses:"); //setup expenses
      
      for(int i = 0; i < costList.length; i++){if(costList[i] < 0){
         expenses += costList[i];
         
         printOut(nameList[i], costList[i], size, false); //see top of page
      }}
      printOut("Subtotal:", expenses, size, true);
      System.out.println();
      printOut("Total:", income + expenses, size, true);
   }
}
