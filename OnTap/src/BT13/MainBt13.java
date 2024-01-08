package BT13;

public class MainBt13 {
    public static void main(String[] args) {
        Stock SUNW = new Stock("SUNW", "Sun Microsystems Inc");
        SUNW.setPreviousClosingPrice(100);
        SUNW.setCurrentPrice(90);
        System.out.println("Stock Symbol: " + SUNW.getSymbol());
        System.out.println("Srock Name: " + SUNW.getName());
        System.out.println("Change Percent: " + SUNW.changePercent() + "%");
    }
}
