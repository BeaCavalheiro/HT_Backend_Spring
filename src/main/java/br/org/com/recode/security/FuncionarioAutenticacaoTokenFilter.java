package br.org.com.recode.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.org.com.recode.model.Cliente;
import br.org.com.recode.model.Funcionario;
import br.org.com.recode.repository.ClienteRepository;
import br.org.com.recode.repository.FuncionarioRepository;

public class FuncionarioAutenticacaoTokenFilter extends OncePerRequestFilter {

	private FuncionarioTokenService userTokenService;
	private FuncionarioRepository userRepository;

	public FuncionarioAutenticacaoTokenFilter(FuncionarioTokenService userTokenService, FuncionarioRepository userRepository) {

		this.userTokenService = userTokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);

		boolean valido = userTokenService.isTokenValid(token);
		System.out.println("AutenticacaoTokenFilter" + valido);
		if (valido) {

			autenticarUser(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarUser(String token) {

		Long idUser = userTokenService.getIdUser(token);

		Funcionario user = userRepository.findById(idUser).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
				user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String recuperarToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			System.out.println(" USER AutenticacaoTokenFilter AQUI TBM");
			return null;
		} else {
			return token.substring(7, token.length());
		}
	}

}
