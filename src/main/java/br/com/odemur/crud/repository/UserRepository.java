package br.com.odemur.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.odemur.crud.domain.User;

/**
 * User Repository
 * 
 * @author Odemur Marangoni
 * 
 * @version 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}