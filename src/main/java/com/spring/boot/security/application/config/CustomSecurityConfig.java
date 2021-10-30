
package com.spring.boot.security.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.boot.security.application.service.UserService;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

	public CustomSecurityConfig() {
		System.out.println("CustomSecurityConfig() default constructor : CustomSecurityConfig >>>>>>>>>>>> ");
	}

	@Autowired
	private UserService userService;

	//
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// order-1
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/registration/**", "/main/**", "/js/**", "/css/**", "/img/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/main/login").permitAll().and().logout()
				.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/main/logout")).logoutSuccessUrl("/main/login?logout")
				.permitAll();

		// anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
	}

	// order-2 :based on the settings below.
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	// order-3 :here i am passing authenticationProvider as a dependency to the
	// auth.authenticationProvider(-) of AuthMgnrBuilder
	@Override
	protected void configure(AuthenticationManagerBuilder builder) {
		builder.authenticationProvider(authenticationProvider());
	}
}
