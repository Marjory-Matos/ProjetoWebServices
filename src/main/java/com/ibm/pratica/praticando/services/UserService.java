package com.ibm.pratica.praticando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.pratica.praticando.model.User;
import com.ibm.pratica.praticando.repository.UserRespository;

//Implementacao das regras de negocio
//Verificara com o repository o que esta sendo requisitado

//registra um servico na camada de servico
@Service
public class UserService {
	
	//realiza a injecao de dependencias
	@Autowired
	private UserRespository repository;
	
	//metodo que busca todos os usuarios
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//metodo que busca todos os usuarios por id
	public User findById(Long id){
		 Optional<User> obj = repository.findById(id);
		 return obj.get();
	}
	
	//metodo para salvar um usuario no banco de dados
	public User insert(User obj) {
		return repository.save(obj);
	}

	
	//delecao do usuario
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
