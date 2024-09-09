package br.com.isacribeiro.secure_password.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isacribeiro.secure_password.Models.Password;
import br.com.isacribeiro.secure_password.Services.PasswordService;

@RestController
public class PasswordController {

	@Autowired
	PasswordService service;
	@PostMapping("/validate-password")
	public ResponseEntity validatePassword(@RequestBody Password password){
		try{
			var p = service.create(password);
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
}
