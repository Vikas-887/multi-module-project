import com.sahubrothers.entity.User;
import com.sahubrothers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sahubrothers.*"})
@EntityScan(basePackages = {"com.sahubrothers.*"})
@EnableJpaRepositories(basePackages = {"com.sahubrothers.*"})
public class HMSApplication {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List< User > users = Stream.of(
                new User(101, "sahubrothers", "password", "sahubrothers@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect( Collectors.toList());
        repository.saveAll(users);
    }
    public static void main(String[] args) {

        SpringApplication.run(HMSApplication.class);
    }
}
