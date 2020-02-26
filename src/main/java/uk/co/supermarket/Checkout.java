package uk.co.supermarket;

public class Checkout {

    public int scan(char itemCode) {
        if (itemCode == 'A') {
            return 50;
        }

        return 0;
    }
}
