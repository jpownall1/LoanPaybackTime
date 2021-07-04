package code;

import java.util.Scanner;

public class RunLoanPaybackCalculator {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your total loan postgraduation: ");
		double loan = in.nextDouble();
		System.out.print("Please enter your wage (assume this stays constant): ");
		double wage = in.nextDouble();
		in.close();
		
		LoanPaybackCalculator toUse = new LoanPaybackCalculator(loan, wage);
		System.out.println(toUse.getPayback());
		
	}
	
}