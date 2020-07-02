package spring.country.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created 15 / 06 / 2020 - 6:17 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

}
