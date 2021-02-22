package br.mp.mpf.cursowebservice.cursowebservice.model.repository;

import br.mp.mpf.cursowebservice.cursowebservice.model.dto.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends  JpaRepository<ProdutoDTO, Integer>{

}