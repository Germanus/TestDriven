package my.ilya.money;



public class Money implements Expression{

	private int amount;
	private String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Expression times(int time){
		return new Money(amount * time, currency);
	}
	
	public String currency(){
		return currency;
	}
	
	public static Money dollar(int money){
		return new Money(money, "USD");
	}
	
	public static Money franc(int money){
		return new Money(money, "CHF");
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public boolean equals(Object money) {
		Money dollar = (Money) money;
		return dollar.getAmount() == this.amount && dollar.getCurrency().equals(this.getCurrency());
	}

	public Expression plus(Expression dollar) {
		return new Sum(this, dollar);
	}

	public Money reduce(Bank bank, String to){
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
	
}

