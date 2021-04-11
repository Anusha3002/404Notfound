package io.heckthon.cryptography;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${security.enable.csrf}")
   	private boolean csrfEnabled;

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/register").permitAll()
		.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/api/**").permitAll()
		.antMatchers("/test").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin();
		//.loginPage("/login").permitAll().and().logout().permitAll();


		/*if(csrfEnabled){
			http.csrf().disable();
		}*/
		http.csrf().disable();
	}
}
