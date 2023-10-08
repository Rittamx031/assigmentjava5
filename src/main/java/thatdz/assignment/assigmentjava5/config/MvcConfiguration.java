package thatdz.assignment.assigmentjava5.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
    viewControllerRegistry.addViewController("/admin").setViewName("redirect:thatpee/manager/home");
    viewControllerRegistry.addViewController("/").setViewName("redirect:thatpee/index");
  }

}
