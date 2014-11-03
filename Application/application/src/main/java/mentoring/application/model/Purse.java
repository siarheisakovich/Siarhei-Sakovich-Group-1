package mentoring.application.model;

public class Purse {

	private String name;
	
	private Currency currency;
	
	private long amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

    @Override
    public String toString() {
        return "Purse [name=" + name + ", currency=" + currency + ", amount="
                + amount + "]";
    }
	
	
}
