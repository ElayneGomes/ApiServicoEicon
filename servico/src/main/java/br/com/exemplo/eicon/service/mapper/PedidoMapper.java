package br.com.exemplo.eicon.service.mapper;

import org.mapstruct.Mapper;

import br.com.exemplo.eicon.domain.Pedido;
import br.com.exemplo.eicon.service.dto.PedidoDTO;

@Mapper(componentModel = "spring")
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido> {
}
