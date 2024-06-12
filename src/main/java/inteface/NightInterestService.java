package inteface;

public class NightInterestService implements InterestService {
    private static final double INTEREST_RATE = 0.10;

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }
}
