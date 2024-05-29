package swagger.test;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

//    @Bean                 // JWT를 사용하는 경우
//    public OpenAPI openAPI() {
//        String jwt = "JWT";
//        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);
//        Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
//                .name(jwt)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("bearer")
//                .bearerFormat("JWT")
//        );
//        return new OpenAPI()
//                .components(new Components())
//                .info(apiInfo())
//                .addSecurityItem(securityRequirement)
//                .components(components);
//    }

    private Info apiInfo() {
        return new Info()
                .title("API Test") // todo API의 제목(swagger-ui.html에서 보이는 제목 : 큰 글자)
                .description("Let's practice Swagger UI") // todo API에 대한 설명(swagger-ui.html에서 보이는 설명 : 작은 글자)
                .version("1.0.0"); // todo API의 버전(swagger-ui.html에서 회색 원 안에 있는 숫자)
    }
}