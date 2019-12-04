package br.com.exemplo.eicon.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.exemplo.eicon.domain.Cliente;
import br.com.exemplo.eicon.repository.ClienteRepository;
import br.com.exemplo.eicon.service.ClienteService;
import br.com.exemplo.eicon.service.dto.ClienteDTO;
import br.com.exemplo.eicon.service.mapper.ClienteMapper;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    private ClienteDTO construirRetorno(Cliente cliente) {
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);
        return clienteDTO;
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        return optional.map(cliente -> clienteMapper.toDto(cliente))
                .orElseThrow(EntityNotFoundException::new);
    }

	@Override
	public List<ClienteDTO> listarTodos() {
		return clienteMapper.toDto(clienteRepository.findAll());
	}
}
