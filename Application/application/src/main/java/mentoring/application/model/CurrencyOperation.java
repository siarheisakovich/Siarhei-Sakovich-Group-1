package mentoring.application.model;

public class CurrencyOperation {
    
    private String fromCurrency;
    
    private String toCurrency;
    
    private double coefficent;
    
    public String getFromCurrency() {
        return fromCurrency;
    }
    
    public String getToCurrency() {
        return toCurrency;
    }
    
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }
    
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getCoefficent() {
        return coefficent;
    }

    public void setCoefficent(double coefficent) {
        this.coefficent = coefficent;
    }

    @Override
    public String toString() {
        return fromCurrency.toString() + "->" + toCurrency.toString() + " "
                + coefficent;
    }
    
    
    
}
