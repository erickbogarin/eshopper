package br.com.eshopper.ecommerce.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users;

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("dan").password("password").roles("ADMIN")
				.and()
			.withUser("joe").password("password").roles("USER");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/uploaded-images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
			.antMatchers("/auth/**").permitAll()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/hello/**").permitAll()
			.antMatchers("/shopping/**").permitAll()
			.antMatchers("/payment/**").permitAll()
			.antMatchers("/produtos/**").permitAll()
			.antMatchers("/wro/**").permitAll()
			.antMatchers("/v1/**").permitAll()
			.antMatchers("/report/**").permitAll()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
				.and().formLogin().failureUrl("/login?auth=fail").defaultSuccessUrl("/")
					.loginPage("/login").permitAll()
				.and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
			http.csrf().disable();
	}

}
