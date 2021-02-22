package br.mp.mpf.cursowebservice.cursowebservice.service;

import br.mp.mpf.cursowebservice.cursowebservice.model.Produto;
import br.mp.mpf.cursowebservice.cursowebservice.model.dto.CategoriaDTO;
import br.mp.mpf.cursowebservice.cursowebservice.model.dto.ProdutoDTO;
import br.mp.mpf.cursowebservice.cursowebservice.model.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ProdutoDTO buscarProdutoById(Integer id) {
        Optional<ProdutoDTO> produto = this.produtoRepository.findById(id);
        return produto.orElse(null);
    }

    private ProdutoDTO mapEntityToDTO(ProdutoDTO produto) {
        return this.modelMapper.map(produto, ProdutoDTO.class);
    }

}
