package br.com.exemplo.eicon.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface responsável por assinar os métodos comuns que serão utilizados pelos serviços (Services)
 *
 * @param <DTO> Data Transfer Object utilizado para trafegar os dados
 * @param <PK> Primary Key, tipo do objeto utilizado como primary key (Ex: Long, Integer, etc)
 */
public interface IBaseService<DTO, PK> {

    DTO buscarPorId(PK id);

    List<DTO> getAll();

    Page<DTO> getPageable(Pageable pageable);

    Page<DTO> pesquisar(DTO dto, Pageable pageable);

    //List<T> getSearchAllByFiltro(F filtro);

    DTO salvar(@Valid DTO t);

    DTO editar(@Valid DTO t);

    void apagar(PK id);

    //Page<T> getSearch(F filtro, Pageable pageable);

}
