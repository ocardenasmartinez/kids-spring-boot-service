package cl.kids.configurations;

import cl.kids.business.KidsBusiness;
import cl.kids.business.KidsBusinessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public KidsBusiness getKidsBusiness() {
        return new KidsBusinessImpl();
    }

}
