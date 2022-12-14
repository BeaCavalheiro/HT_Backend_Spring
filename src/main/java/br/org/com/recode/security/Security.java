package br.org.com.recode.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.org.com.recode.repository.ClienteRepository;
import br.org.com.recode.repository.FuncionarioRepository;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	@Autowired
	private FuncionarioAutenticacaoService userAutenticacaoService;

	@Autowired
	private TokenService tokenService;
	@Autowired
	private FuncionarioTokenService userTokenService;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private FuncionarioRepository userRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// CONFIG AUTENTICAÇÂO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

		auth.userDetailsService(userAutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// CONFIG DE AUTORIZAÇÂO
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.POST, "/cadastrar").permitAll()
		.antMatchers(HttpMethod.POST, "/user/auth").permitAll()
		.antMatchers(HttpMethod.POST, "/user/cadastrar").permitAll()
		.antMatchers(HttpMethod.GET, "/listar").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, clienteRepository), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new FuncionarioAutenticacaoTokenFilter(userTokenService, userRepository), UsernamePasswordAuthenticationFilter.class);

		
	}

	// CONFIG DE RECURSOS ESTATICOS
	@Override
	public void configure(WebSecurity web) throws Exception {

	}

}
