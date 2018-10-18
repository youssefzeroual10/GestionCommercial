package org.manolo;


import javax.sql.DataSource;

import org.manolo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	//@Autowired
    //private AccessDeniedHandler accessDeniedHandler;
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource datasource) throws Exception{
		// add a user in memory
		//auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
		
		auth.jdbcAuthentication()
			.dataSource(datasource)
					.usersByUsernameQuery("select id_user as principal,password as credentials , true from user where id_user=?").passwordEncoder(passwordEncoder())
					.authoritiesByUsernameQuery("select user_id_user as principal , roles_role as role , true from user_role where user_id_user=?").rolePrefix("ROLE_")
					;
		
	}
	 @Override
	protected void configure(HttpSecurity http)throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/app/**","/bootstrap-3.3.7-dist/**","/css/**","/js/**","/font/**","/report/**","/img/**","/layout/**").permitAll()
								.anyRequest()
					.authenticated()
				
						.and()
			.formLogin()
				.loginPage("/login")
					.permitAll()
					.defaultSuccessUrl("/tableauBord")
					.failureUrl("/erreur")
					//.addFilterAfter(new CsrfHeaderFilter(), CsrfHeaderFilter.class)
					.and()
					 .logout()
						.permitAll()
						.and()
						
//	                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
;
			http.csrf().disable();

	}
	 @Bean
		public PasswordEncoder passwordEncoder(){
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}
	 
}
