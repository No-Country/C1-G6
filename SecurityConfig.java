package io.orderup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableJpaAuditing
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private XMUserDetailsService xmuserDetailsService;
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(xmuserDetailsService);
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.authorizeRequests().antMatchers("/api").authenticated().and().httpBasic().and()
        .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }/*

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*").allowedOrigins("http://localhost:4200","http://localhost:3000");
                registry.addMapping("/api/products/*").allowedOrigins("http://localhost:3000");
                registry.addMapping("http://localhost:8090/api/products/?name=ferrari").allowedOrigins("http://localhost:4200","http://localhost:3000");
            }
        };
    }


    /*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/
}
