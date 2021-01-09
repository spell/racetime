package gg.racetime.racetime;

import gg.racetime.racetime.user.User;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RacetimeConfig {
    @Value("${racetime.hashids.secret}")
    private String secret;

    @Value("${racetime.hashids.min-length}")
    private int minHashLength;

    @Bean(name = "userHashids")
    public Hashids userHashids() {
        return new Hashids(User.PYTHON_CLASS + secret, minHashLength);
    }
}
