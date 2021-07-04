package code;

public class LoanPaybackCalculator {

	private double loan;
	private double wage;
	
	public LoanPaybackCalculator(double l, double w) {
		if (l < 0) { throw new IllegalArgumentException("Loan cannot be negative"); } 
		else if (w <= 25000) { throw new IllegalArgumentException("You will not pay back anything"); }
		this.loan = l;
		this.wage = w;
	}
	
	public double getLoan() {
		return this.loan;
	}
	
	public double getWage() {
		return this.wage;
	}
	
	public double getInterest() {
		if (wage <= 27295) { return 2.6/100; }
		else if (wage <= 49130) { return (2.6 + ((49130-wage)/21834)*3)/100; }
		return 5.6/100;
	}
	
	public double paidPerYear() {
		double difference = wage - 25000;
		double paid = difference * 0.09;
		return paid;
	}
	
	public int yearsRequired() {
		int yearsRemaining = 30;
		double remainingLoan = this.loan;
		while (yearsRemaining >= 0 && remainingLoan > 0) {
			remainingLoan = remainingLoan - paidPerYear();
			remainingLoan = remainingLoan + remainingLoan * getInterest();
			yearsRemaining = yearsRemaining - 1;
		}
		return yearsRemaining;
	}
	
	public String getPayback() {
		if (yearsRequired() <= 0) {
			int years = 0;
			while (years <= 0) {
				this.wage = this.wage + 1000;
				years = yearsRequired();
			}
			return "If you dont contribute over the required amount, your debt will be wrote off. To pay off your loan "
					+ "within 30 years, you need a wage of around " + wage + ".";
		}
		return "You will pay off your loan in " + (30-yearsRequired()) + " years by paying " + paidPerYear() + " a year.";
	}
	
}
