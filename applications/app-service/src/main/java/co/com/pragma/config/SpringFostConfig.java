package co.com.pragma.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableSwagger2
public class SpringFostConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Torneos de Videojuegos")
                        .version("v1")
                        .description("Proporciona funciones especificas para la gestion de crear y organizar eventos virtuales de torneos de videojuegos")
                        //.license()
                );
    }

}
