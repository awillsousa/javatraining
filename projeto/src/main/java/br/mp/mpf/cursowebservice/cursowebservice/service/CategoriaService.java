package br.mp.mpf.cursowebservice.cursowebservice.service;

import br.mp.mpf.cursowebservice.cursowebservice.model.dto.CategoriaDTO;
import br.mp.mpf.cursowebservice.cursowebservice.model.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public CategoriaDTO buscarCategoriaById(Integer id) {
        Optional<CategoriaDTO> categoria = this.categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    private CategoriaDTO mapEntityToDTO(CategoriaDTO categoria) {
        return this.modelMapper.map(categoria, CategoriaDTO.class);
    }
}
