
package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration 
@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.*"})
public class SpringBootWebApplication {
	
	static
	{
		System.setProperty("spring.config.location","file:C:\\Users\\rgundabathula\\Desktop\\auth.yml,file:C:\\Users\\rgundabathula\\eclipse-workspace\\CrudUsingMongoDB\\src\\main\\resources\\application.properties");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
