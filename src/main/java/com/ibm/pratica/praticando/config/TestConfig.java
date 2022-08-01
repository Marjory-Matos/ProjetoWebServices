package com.ibm.pratica.praticando.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ibm.pratica.praticando.model.Pedido;
import com.ibm.pratica.praticando.model.User;
import com.ibm.pratica.praticando.model.enums.OrderStatus;
import com.ibm.pratica.praticando.repository.PedidoRepository;
import com.ibm.pratica.praticando.repository.UserRespository;
/*
  Classe de configuracao especifica para teste
 */


@Configuration
@Profile("test")
//implementando o command para que o run seja executado quando o projeto for rodado
public class TestConfig implements CommandLineRunner{
	
	//realiza a injecao de dependencias
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	/*
	 * Instanciando os objetos e salvando no banco de dados
	 */
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "MariaSocial");
		User u2 = new User(null, "Marcio", "MarcioSocial");
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:072"), OrderStatus.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-20T19:53:080"), OrderStatus.WAITING_PAYMENT, u2);
		
		
		userRespository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1, o2));
		
	}
	
	
}
