package br.com.exemplo.eicon.service;

import java.util.Date;
import java.util.List;

import br.com.exemplo.eicon.service.dto.PedidoDTO;

public interface PedidoService {

    PedidoDTO buscarPorNumero(Long numero);

    PedidoDTO buscarPorDataPedido(Date dataPedido);

    List<PedidoDTO> listarTodos();

    PedidoDTO buscarPorId(Long id);

    List<PedidoDTO> buscarPedidoPorIdCliente(Long id);

}
