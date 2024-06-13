package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import factory.InterestServiceFactory;
import inteface.*;

public class InterestModule extends AbstractModule {

    @Override
    protected void configure() {
        //Interface to Class
        bind(CompanyServ.class).to(CompanyImpl.class);
    }
    @Provides
    public InterestService provideInterestService(InterestServiceFactory factory) {
    return factory.getInterestService();
    }
}
