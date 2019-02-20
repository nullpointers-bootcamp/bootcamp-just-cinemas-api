package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.config.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class EmailTest {

    @InjectMocks
    EmailService emailService;

    @Test
    public void shouldSendEmail() {
        boolean success = emailService.sendMail("abistarun@gmail.com", "Test", "Test 1");
        Assert.assertTrue(success);
    }
}
