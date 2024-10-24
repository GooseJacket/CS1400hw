public class Lab71 {
   public static void main(String[] args) {
      double[] userList = {5.22, -10.01, 0.05, -1.01, 7.42, -10.50, 5000.10, -2010.20};
      
      for(double i : userList){
         System.out.print("$ ");
         if(i < 0){ System.out.print("(");} else{System.out.print(" ");}
         System.out.printf("%7.2f", Math.abs(i));   
         if(i < 0){ System.out.println(")");} else{System.out.println();}
      }
   }
}
