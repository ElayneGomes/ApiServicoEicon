package br.com.exemplo.eicon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.exemplo.eicon.config.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_CLIENTE", schema = Constants.SCHEMA_ORACLE_MDSGERAL)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1;
    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    private Long id;

    @Column(name = "DS_CLIENTE")
    private String nome;
}
