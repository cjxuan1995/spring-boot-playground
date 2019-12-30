package applicationContext.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired
//    public ConfigurableMessageProvider(@Value("random message") String message) {
    public ConfigurableMessageProvider(@Value("#{simpleConfig.message}") String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
