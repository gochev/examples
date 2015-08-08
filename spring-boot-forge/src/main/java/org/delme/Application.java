package org.delme;

import org.delme.model.User;
import org.delme.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User();
        user.setFirstName("code retreet");
		userRepository.save(user);
    }
}