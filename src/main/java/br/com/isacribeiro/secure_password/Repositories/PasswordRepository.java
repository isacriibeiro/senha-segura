package br.com.isacribeiro.secure_password.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isacribeiro.secure_password.Models.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

}
