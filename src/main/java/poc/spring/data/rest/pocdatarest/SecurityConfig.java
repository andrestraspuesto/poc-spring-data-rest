package poc.spring.data.rest.pocdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class SecurityConfig 
extends ResourceServerConfigurerAdapter {
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.
//            inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user").password("user").roles("USER").and()
//                .withUser("admin").password("admin").roles("USER","ADMIN");
//    }
 
	@Override
	public void configure(HttpSecurity http) throws Exception {
	    http
	    .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/rest/actors/**").hasAuthority("w_actor")
        .antMatchers(HttpMethod.GET,"/rest/**").hasAuthority("r_actor")
        .antMatchers("/greetings/**").permitAll()
        .and()
      .httpBasic()
        .and()
       .csrf().disable();
	  }
	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//          .authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/rest/actors/**").permitAll()//.hasRole("ADMIN")
//            //.antMatchers("/rest/**").hasAnyRole("ADMIN","USER")
//            //.antMatchers("/greetings/**").hasAnyRole("ADMIN","USER")
//            .and()
//          .httpBasic()
//            .and()
//           .csrf().disable();
//    }
}
