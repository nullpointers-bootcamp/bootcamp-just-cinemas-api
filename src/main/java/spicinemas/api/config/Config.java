package spicinemas.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mail")
public class Config {

    @Value("${mail.smtp.host}")
    private String smtpHost;

    public String getSmtpHost() {
        return smtpHost;
    }

}
