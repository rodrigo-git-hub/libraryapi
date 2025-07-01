package com.rodrigogustavo.Libraryapi.service;

import com.rodrigogustavo.Libraryapi.controller.AutorDTO;
import com.rodrigogustavo.Libraryapi.domain.Autor;
import com.rodrigogustavo.Libraryapi.repositories.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository){
        this.repository = repository;
    }

    public Autor salvar(Autor autor){
        return repository.save(autor);
    }

}
