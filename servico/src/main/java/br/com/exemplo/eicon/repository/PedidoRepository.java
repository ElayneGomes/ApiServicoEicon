package br.com.exemplo.eicon.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.exemplo.eicon.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.exemplo.eicon.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, JpaSpecificationExecutor<Pedido> {

    List<Pedido> findAll();

    Optional<Pedido> findById(Long id);

    Optional<Pedido> findByNumero(Long numero);

    Optional<Pedido> findByDataPedido(Date dataPedido);

    @Query(value = "select id_pedido, dt_pedido, ds_pedido, nr_pedido, id_cliente from TB_PEDIDO where id_cliente = ?1", nativeQuery = true)
    ArrayList<Pedido> findPedidoCliente(Long id_cliente);
}
