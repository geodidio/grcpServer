package factory;

import inteface.DayInterestService;
import inteface.InterestService;
import inteface.NightInterestService;

import javax.inject.Inject;
import java.time.LocalTime;

public class InterestServiceFactory {
    private final DayInterestService dayInterestService;
    private final NightInterestService nightInterestService;

    @Inject
    public InterestServiceFactory(
                                  DayInterestService dayInterestService,
                                  NightInterestService nightInterestService) {
        this.dayInterestService = dayInterestService;
        this.nightInterestService = nightInterestService;
    }

    public InterestService getInterestService() {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(6, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            return dayInterestService;
        } else {
            return nightInterestService;
        }
    }
}

