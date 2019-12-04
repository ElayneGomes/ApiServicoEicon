package br.com.exemplo.eicon.service;

import java.util.List;

import br.com.exemplo.eicon.service.dto.ClienteDTO;

public interface ClienteService {

    List<ClienteDTO> listarTodos();

    ClienteDTO buscarPorId(Long id);

}
