package applicationContext.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "applicationContext.annotation")
public class HelloWorldConfiguration {
//    @Bean
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//    @Bean
//    public MessageRenderer renderer(){
//        MessageRenderer renderer = new StandardOutMessageRenderer();
//        renderer.setMessageProvider(provider());
//        return renderer;
//    }
}
