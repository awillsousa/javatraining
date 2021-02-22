package br.mp.mpf.cursowebservice.cursowebservice.model.repository;

import br.mp.mpf.cursowebservice.cursowebservice.model.dto.CategoriaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaDTO, Integer> {

}
