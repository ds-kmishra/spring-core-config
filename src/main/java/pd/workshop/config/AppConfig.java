package pd.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pd.workshop.service.EmailService;

@Configuration
public class AppConfig {

    @Bean
    public EmailService emailService(){
        return new EmailService();
    }
}
