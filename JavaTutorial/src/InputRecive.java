import java.util.Scanner;

public class InputRecive {
	public static void main(String[] args)
	{
		System.out.println();
		Scanner sc = new Scanner (System.in);
	    Scanner sc2 = new Scanner (System.in);
	    int b; 
	      int a = sc.nextInt();
	      System.out.print("Input second integer: ");
	      b = sc2.nextInt();
	      int op1 = 74;
	      int op2 = 36;
	      System.out.println(74 + 36);
	      System.out.println(op1 + op2);
	      System.out.println("Sum: "+ (a+b));
	}
}
