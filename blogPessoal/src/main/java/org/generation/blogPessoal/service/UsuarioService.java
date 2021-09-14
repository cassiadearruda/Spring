package org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.generation.blogPessoal.entity.UserLoginEntity;
import org.generation.blogPessoal.entity.UsuarioEntity;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioEntity> listarUsuarios() {

        return repository.findAll();

    }

	public Optional<UsuarioEntity> CadastrarUsuario(UsuarioEntity usuario) {
		Optional<UsuarioEntity> user = repository.findByUsuario(usuario.getUsuario());
		if(user.isPresent()) {
			return Optional.ofNullable(null);
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(repository.save(usuario));
	}

	public Optional<UserLoginEntity> Logar(Optional<UserLoginEntity> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioEntity> usuario = repository.findByUsuario(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);				
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			}
		}
		return null;
	}
	
	public Optional<UsuarioEntity> atualizarUsuario(UsuarioEntity usuario) {

        if (repository.findById(usuario.getId()).isPresent()) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            String senhaEncoder = encoder.encode(usuario.getSenha());
            usuario.setSenha(senhaEncoder);

            return Optional.of(repository.save(usuario));

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);

        }
    }

}
