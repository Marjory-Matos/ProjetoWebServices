package com.ibm.pratica.praticando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.pratica.praticando.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
