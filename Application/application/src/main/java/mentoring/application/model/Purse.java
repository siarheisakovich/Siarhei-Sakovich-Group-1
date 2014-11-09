package mentoring.application.model;

public class Purse {

	private String name;
	
	private String currency;
	
	private double amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    @Override
    public String toString() {
        return "Purse [name=" + name + ", currency=" + currency + ", amount="
                + amount + "]";
    }
	
	
}
