import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.repository.StubSpeakerRepositoryImpl;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    @Bean(name="cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }

//    Not needed when the @Service annotation is used
//    @Bean(name="speakerService")
//    @Scope(value= BeanDefinition.SCOPE_SINGLETON) // Ensures the bean is a singleton. Prototype scope gives a different object address instead of the same.
//    public SpeakerService getSpeakerService() {
////        SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
//        SpeakerServiceImpl service = new SpeakerServiceImpl();
////        service.setRepository(getSpeakerRepository());
//        return service;
//    }

//    Not needed when the @Repository annotation is used
//    @Bean(name="speakerRepository")
//    public SpeakerRepository getSpeakerRepository() {
//        return new StubSpeakerRepositoryImpl();
//    }
}
