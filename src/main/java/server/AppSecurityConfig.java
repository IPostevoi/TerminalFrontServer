package server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Конфигурация доступа к урлам, если в терминале стоит флаг авторизации - пускает
 *
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/validate").permitAll()
                .antMatchers("/*").access("@orchestration.isAuthorized()")
                .and().formLogin().loginPage("/");

    }

}
