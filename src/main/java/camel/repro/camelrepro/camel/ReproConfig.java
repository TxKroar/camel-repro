package camel.repro.camelrepro.camel;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource(locations={"/camel-routes.xml"})
public class ReproConfig {
}
