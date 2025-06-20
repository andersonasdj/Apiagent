package br.com.techgold.apiagent.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario implements UserDetails {
	
	private static final long serialVersionUID = 3474835326939061879L;
	@Column(length = 50)
	private String nomeFuncionario;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	private String caminhoFoto;
	
	private LocalDateTime dataAtualizacaoSenha;
	
	private Boolean trocaSenha;
	
	private Boolean ausente;
	
	private Boolean refeicao;
	
	private int tentativasLogin;
	
	private boolean twoFactorVerified = false; // controle interno
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_EDITOR") );
		else if(this.role == UserRole.EDITOR) return List.of(new SimpleGrantedAuthority("ROLE_EDITOR"),new SimpleGrantedAuthority("ROLE_USER"));
		else if(this.role == UserRole.USER) {return List.of(new SimpleGrantedAuthority("ROLE_USER"));}
		else {
			 return List.of(new SimpleGrantedAuthority("PRE_2FA"));
		}
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

