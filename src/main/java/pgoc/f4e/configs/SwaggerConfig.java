package pgoc.f4e.configs;

import com.newrelic.api.agent.Trace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Trace
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("pgoc.f4e"))
        .paths(regex("/.*"))
        .build()
        .apiInfo(apiEndPointsInfo());
  }

  @Trace
  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder()
        .title("Fight4Edu APIs")
        .description("Fight4Edu: Trainig of mind to think")
        .contact(new Contact("Lakshmi S. Patel", "www.fight4edu.com", "patel@fight4edu.com"))
        .license("Fight4Education Pvt. Ltd.")
        .version("v1")
        .build();
  }
}
