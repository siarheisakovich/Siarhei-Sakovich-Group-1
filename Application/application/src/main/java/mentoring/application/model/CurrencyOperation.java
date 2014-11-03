package mentoring.application.model;

public class CurrencyOperation {
    
    private Currency fromCurrency;
    
    private Currency toCurrency;
    
    private float coefficent;

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public float getCoefficent() {
        return coefficent;
    }

    public void setCoefficent(float coefficent) {
        this.coefficent = coefficent;
    }

    @Override
    public String toString() {
        return fromCurrency.toString() + "->" + toCurrency.toString() + " "
                + coefficent;
    }
    
    
    
}
