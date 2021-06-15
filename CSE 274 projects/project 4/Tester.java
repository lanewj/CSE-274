import java.util.Scanner;

public class Tester {
// i believe that all my methods work correctly except for my isValid and Evaluate
	public static void main(String[] args) 
	{
		InfixExpression test1 = new InfixExpression("{[()]}");
		System.out.println("testing if {[()]} is a balanced expression \n Expected Value true");
		boolean test = test1.isBalanced();
		System.out.println("Actual Value " + test + "\n");
		InfixExpression test7 = new InfixExpression("{()]}");
		System.out.println("testing if {()]} is a balanced expression \n Expected Value false");
		 test = test7.isBalanced();
		System.out.println("Actual Value " + test + "\n");
		InfixExpression test8 = new InfixExpression("{(()]}");
		System.out.println("testing if {(()]} is a balanced expression \n Expected Value false");
		 test = test8.isBalanced();
		System.out.println("Actual Value " + test + "\n");
		InfixExpression test2 = new InfixExpression("2+3*5");
		System.out.println("converting 2+3*5 to postfix");
		String ret = test2.getPostfixExpression();
		System.out.println("expected value 235*+");
		System.out.println("Actual Value " + ret + "\n");
		System.out.println("converting 2+3*5/8 to postfix");
		InfixExpression test3 = new InfixExpression("2+3*5/8");
		ret = test3.getPostfixExpression();
		System.out.println("expected value 2 3 5 * 8 / +");
		System.out.println("Actual Value " + ret + "\n");
		System.out.println("converting (5+4)/(4-1) to postfix");
		InfixExpression test4 = new InfixExpression("(5+4)/(4-1)");
		ret = test4.getPostfixExpression();
		System.out.println("expected value 54+41-/");
		System.out.println("Actual Value " + ret);
		System.out.println("evaluating expression 2+3");
		InfixExpression test5 = new InfixExpression("2+3");
		//evaluting postfix
		int ret2 = test5.evaluatePostfix();
		System.out.println("expected value 5");
		System.out.println("Actual Value " + ret2 +  " \n");
		System.out.println("evaluating expression 2+3");
		InfixExpression test6 = new InfixExpression("2^2^3");
		ret2 = test6.evaluatePostfix();
		System.out.println("expected value 256");
		System.out.println("Actual Value " + ret2 +  " \n");
		
		Scanner scanner = new Scanner(System. in);
		System.out.println("enter equation you would like to test");
		String input = scanner. nextLine();		
		InfixExpression inputTest = new InfixExpression(input);
		System.out.println("postfix "+ inputTest.getPostfixExpression());
		System.out.println("Evaluating expression " + inputTest.evaluatePostfix() );
		
	}

}
