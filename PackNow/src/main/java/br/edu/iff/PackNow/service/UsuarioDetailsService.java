package br.edu.iff.PackNow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.PackNow.model.Usuario;
import br.edu.iff.PackNow.model.Permissao;
import br.edu.iff.PackNow.repository.PermissaoRepository;
import br.edu.iff.PackNow.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRep;
	@Autowired
	private PermissaoRepository permissaoRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRep.findByLogin(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getLogin(), usuario.getSenha(), authorities(usuario.getPermissoes()));
	}
	public List<? extends GrantedAuthority> authorities(List<Permissao> lista){
		List<GrantedAuthority> auths = new ArrayList<>();
		for(Permissao permissao : lista) {
			auths.add(new SimpleGrantedAuthority("ROLE_"+permissao.getNome()));
		}
		return auths;
	}
}
