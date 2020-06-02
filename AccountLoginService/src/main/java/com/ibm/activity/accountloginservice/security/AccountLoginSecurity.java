package com.ibm.activity.accountloginservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AccountLoginSecurity extends WebSecurityConfigurerAdapter {

	@Autowired	
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("anuj").password("anuj").roles("Admin").and().withUser("blah")
			//	.password("blah").roles("User");
		
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/loginservice/superuser").hasRole("Admin")
				.antMatchers("/loginservice/msg").hasAnyRole("User", "Admin").antMatchers("/loginservice").permitAll()
				.antMatchers("/console/**").hasRole("Admin") 
				.anyRequest().authenticated()                
				.and().formLogin()                            
				.and().csrf().ignoringAntMatchers("/h2-console/**") 
				.and().headers().frameOptions().sameOrigin();
	}
}
