package inteface;

public class DayInterestService implements InterestService{
    private static final double INTEREST_RATE = 0.05;

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }
}
