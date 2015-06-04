package my.ilya.money;

public class Sum implements Expression{
	
	public Expression augend;
	public Expression addend;
	
	public Sum(Expression augend, Expression addend) {
		this.addend = addend;
		this.augend = augend;
	}
	
	public Money reduce(Bank bank, String to){
		int amount = ((Money) augend.reduce(bank, to)).getAmount() + ((Money)addend.reduce(bank, to)).getAmount();
		return new Money(amount, to);
	}

	public Expression plus(Expression added) {
		return new Sum(this, addend);
	}

	public Expression times(int multiplier){
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}
}
