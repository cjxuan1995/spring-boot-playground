package applicationContext.annotation;

import org.springframework.stereotype.Component;

@Component("simpleConfig")
public class SimpleConfig {
    private final String message = "Message from simple config class";

    public String getMessage() {
        return message;
    }
}
