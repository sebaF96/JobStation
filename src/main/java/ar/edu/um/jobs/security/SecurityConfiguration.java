package ar.edu.um.jobs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/comp/register").permitAll()
                .antMatchers("/dev/register").permitAll()
                .antMatchers("/job/c/**").hasRole("COMPANY")
                .antMatchers("/dev/**").hasRole("DEVELOPER")
                .antMatchers("/comp/**").hasRole("COMPANY")
                .antMatchers("/application/d/**").hasRole("DEVELOPER")
                .antMatchers("/application/c/**").hasRole("COMPANY")
                .antMatchers("/user").hasAnyRole("COMPANY", "DEVELOPER")
                .antMatchers("/").permitAll()
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
