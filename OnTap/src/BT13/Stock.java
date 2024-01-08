package BT13;

public class Stock {
    String symbol, name;
    float previousClosingPrice;
    float currentPrice;

    public Stock() {
    }

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public float getPreviousClosingPrice() {
        return previousClosingPrice;
    }
    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(float previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float changePercent(){
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}
