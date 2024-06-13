import inteface.Company;
import inteface.CompanyServ;
import inteface.InterestService;
import myapp.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

// Use MockitoJUnitRunner to initialize mocks
public class CompanyServiceMock {

    // Mock dependencies
    @Mock
    private InterestService interestService;
    @InjectMocks
    private Company companyServ;


    @Before
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInterest() {
        // set up mock behavior
        double amount = 100;
        double interest = 0.05;

        when(this.interestService.calculateInterest(amount)).thenReturn(interest);
        double result = this.interestService.calculateInterest(amount);
        // verify that mock behavior was called
        verify(interestService).calculateInterest(amount);
        // Assert
        assertEquals(interest, result, 0.001);
    }
    @Test
    public void testRank(){
        int result =  this.companyServ.rank(2);
        assertEquals(4, result);
    }
}
