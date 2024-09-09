package br.com.isacribeiro.secure_password.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isacribeiro.secure_password.Models.Password;
import br.com.isacribeiro.secure_password.Repositories.PasswordRepository;

@Service
public class PasswordService {

	@Autowired
	PasswordRepository repository;
	
	public Password create(Password password) {
		String senha = password.getPassword();
		
		if(senha.length() < 8) {
			throw new IllegalArgumentException("Sua senha precisa de pelo menos 8 caracteres.");
		}
		
		char[] caracteres = senha.toCharArray();
		boolean isUpper = false;
		boolean isLower = false;
        boolean isDigit = false;
        boolean isSpecial = false;
		for (char c : caracteres) {
		    if (Character.isUpperCase(c)) {
		        isUpper = true;
		    } else if (Character.isLowerCase(c)) {
		        isLower = true;
		    }
		    else if(Character.isDigit(c)) {
		    	isDigit = true;
		    }
		    else if(!Character.isLetterOrDigit(c)) {
		    	isSpecial = true;
		    }

		    if (isUpper && isLower && isDigit && isSpecial) {
		        break;
		    }
		}

		if (!isUpper) {
		    throw new IllegalArgumentException("Sua senha precisa conter pelo menos uma letra maiúscula");
		}
		if (!isLower) {
		    throw new IllegalArgumentException("Sua senha precisa conter pelo menos uma letra minúscula");
		}
		if (!isDigit) {
		    throw new IllegalArgumentException("Sua senha precisa conter pelo menos um dígito numérico");
		}
		if (!isSpecial) {
		    throw new IllegalArgumentException("Sua senha precisa conter pelo menos um caractere especial");
		}


		var passwordVerify = repository.save(password);
		return passwordVerify;
	}
}
