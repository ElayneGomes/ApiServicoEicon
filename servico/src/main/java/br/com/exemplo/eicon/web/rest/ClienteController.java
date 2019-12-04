package br.com.exemplo.eicon.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.eicon.service.ClienteService;
import br.com.exemplo.eicon.service.dto.ClienteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/api/clientes")
@Api(value="/api/clientes", tags = {"Clientes"})
@SwaggerDefinition(tags = {
        @Tag(name = "Clientes", description = "Clientes")
})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    @ApiOperation(value = "Pesquisar Clientes", response = ResponseEntity.class)
    public ResponseEntity<List<ClienteDTO>> pesquisar(ClienteDTO filtro, Pageable pageable) {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar Cliente pelo ID", response = ResponseEntity.class)
    public ResponseEntity<ClienteDTO> consultar(@PathVariable Long id) {
        ClienteDTO pedidoDTO = clienteService.buscarPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

}