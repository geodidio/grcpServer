package factory;

import inteface.DayInterestServiceImpl;
import inteface.InterestService;
import inteface.NightInterestServiceImpl;

import javax.inject.Inject;
import java.time.LocalTime;

public class InterestServiceFactory {
    private final DayInterestServiceImpl dayInterestService;
    private final NightInterestServiceImpl nightInterestService;

    @Inject
    public InterestServiceFactory(
            DayInterestServiceImpl dayInterestService,
                                  NightInterestServiceImpl nightInterestService) {
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

