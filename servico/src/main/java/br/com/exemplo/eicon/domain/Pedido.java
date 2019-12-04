package br.com.exemplo.eicon.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.exemplo.eicon.config.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_PEDIDO", schema = Constants.SCHEMA_ORACLE_MDSGERAL)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1;
    @Id
    @Column(name = "ID_PEDIDO", nullable = false)
    private Long id;

    @Column(name = "DS_PEDIDO")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @Column(name = "DT_PEDIDO")
    private Date dataPedido;
    
    @Column(name = "NR_PEDIDO")
    private Long numero;
}
