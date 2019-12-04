package br.com.exemplo.eicon.service.mapper;

import org.mapstruct.Mapper;

import br.com.exemplo.eicon.domain.Cliente;
import br.com.exemplo.eicon.service.dto.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {
}
