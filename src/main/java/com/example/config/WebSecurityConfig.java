package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import com.example.securingweb.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	 /* @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    	//auth.userDetailsService(userDetailsService());
	    }*/
	 
	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers("/", "/product/**", "/register", "/load", "/h2-console/**").permitAll()
	        .antMatchers("/h2-console/**").permitAll()
	        .antMatchers("/customer/**").hasAuthority("ADMIN")   
	        .anyRequest().authenticated()
	            .and()
	            .formLogin().permitAll()
	            .and()
	            .logout().permitAll();
	            
	            http.csrf().disable();
	        http.headers().frameOptions().disable();
	    	
	    	/*http
			.authorizeRequests()
				.antMatchers("/", "/home", "/register", "/load").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/admin").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		//only for h2-console
		http.csrf().disable();
     http.headers().frameOptions().disable();*/
	    }
	 
	 @Bean
		@Override
		public UserDetailsService userDetailsService() {
			/*UserDetails user =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user);
		*/
		 return new com.example.services.impl.UserDetailsServiceImpl();	 
	 }
}
