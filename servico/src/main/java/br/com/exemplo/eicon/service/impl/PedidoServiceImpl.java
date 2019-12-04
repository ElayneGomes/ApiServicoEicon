package br.com.exemplo.eicon.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.exemplo.eicon.domain.Pedido;
import br.com.exemplo.eicon.repository.PedidoRepository;
import br.com.exemplo.eicon.service.PedidoService;
import br.com.exemplo.eicon.service.dto.PedidoDTO;
import br.com.exemplo.eicon.service.mapper.PedidoMapper;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public PedidoDTO buscarPorNumero(Long numero) {
        Optional<Pedido> optional = pedidoRepository.findByNumero(numero);
        return optional.map(pedido -> pedidoMapper.toDto(pedido))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public PedidoDTO buscarPorDataPedido(Date dataPedido) {
        Optional<Pedido> optional = pedidoRepository.findByDataPedido(dataPedido);
        return optional.map(pedido -> pedidoMapper.toDto(pedido))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return pedidoMapper.toDto(pedidoRepository.findAll());
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        return optional.map(pedido -> pedidoMapper.toDto(pedido))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<PedidoDTO> buscarPedidoPorIdCliente(Long idCliente) {
        return pedidoMapper.toDto(pedidoRepository.findPedidoCliente(idCliente));
    }

}