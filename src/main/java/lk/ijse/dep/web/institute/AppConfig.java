package lk.ijse.dep.web.institute;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-17
 **/

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
@Import(JPAConfig.class)
public class AppConfig {
}
