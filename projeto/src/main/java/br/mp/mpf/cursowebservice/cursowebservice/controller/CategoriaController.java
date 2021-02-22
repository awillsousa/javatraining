package br.mp.mpf.cursowebservice.cursowebservice.controller;

import br.mp.mpf.cursowebservice.cursowebservice.model.dto.CategoriaDTO;
import br.mp.mpf.cursowebservice.cursowebservice.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCategoriaById(@PathVariable Integer id) {

        CategoriaDTO categoriaDTO = this.categoriaService
                .buscarCategoriaById(id); //.orElse(null);
        if (categoriaDTO != null) {
            return ResponseEntity.ok().body(categoriaDTO);
        } else {
            return ResponseEntity.badRequest().body("Categoria não encontrado com o ID: "+ id);
        }

    }
}
