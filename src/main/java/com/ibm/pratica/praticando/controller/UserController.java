package com.ibm.pratica.praticando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.pratica.praticando.model.User;
import com.ibm.pratica.praticando.services.UserService;


/*controlador que faz o meio de campo entre a aplicacao e as regras de negocio
o controlador ira depender do servico e o servico do repository */

//value define o nome dos endpoints
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	//Esta injecao realiza a injecao de dependencias
	@Autowired
	private UserService service;
	
	
	//Este metodo busca todos os usuarios
	//ResponseEntity retorna respostas de requisicoes web
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Este metodo busca todos os usuarios por id
	/*o value informa que iremos passar o id dentro da url 
	e para receber como parametro adiciamos o Path */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
