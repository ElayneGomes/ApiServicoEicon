package br.com.exemplo.eicon.web.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.exemplo.eicon.service.PedidoService;
import br.com.exemplo.eicon.service.dto.PedidoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/pedidos")
@Api(value="/api/pedidos", tags = {"Pedidos"})
@SwaggerDefinition(tags = {
        @Tag(name = "Pedidos", description = "Pedidos")
})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/listar")
    @ApiOperation(value = "Pesquisar Pedidos", response = ResponseEntity.class)
    public ResponseEntity<List<PedidoDTO>> pesquisar(PedidoDTO filtro, Pageable pageable) {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar Pedido pelo ID", response = ResponseEntity.class)
    public ResponseEntity<PedidoDTO> consultar(@PathVariable Long id) {
        PedidoDTO pedidoDTO = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/peloNumero/{numero}")
    @ApiOperation(value = "Consultar Pedido pelo numero", response = ResponseEntity.class)
    public ResponseEntity<PedidoDTO> consultarPorNumero(@PathVariable Long numero) {
        PedidoDTO pedidoDTO = pedidoService.buscarPorNumero(numero);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/pelaData/{dataPedido}")
    @ApiOperation(value = "Consultar Pedido pela Data de Cadastro", response = ResponseEntity.class)
    public ResponseEntity<PedidoDTO> consultarPorData(@PathVariable Date dataPedido) {
        PedidoDTO pedidoDTO = pedidoService.buscarPorDataPedido(dataPedido);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/peloIdCliente/{id_cliente}")
    @ApiOperation(value = "Consultar Pedido pelo Cliente", response = ResponseEntity.class)
    public  List<PedidoDTO> consultarPorIdCliente(@PathVariable Long id) {
        return pedidoService.buscarPedidoPorIdCliente(id);
    }

}