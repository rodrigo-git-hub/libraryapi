package com.rodrigogustavo.Libraryapi.validator;

import com.rodrigogustavo.Libraryapi.domain.Autor;
import com.rodrigogustavo.Libraryapi.exceptions.RegistroDuplicadoException;
import com.rodrigogustavo.Libraryapi.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    @Autowired
    private AutorRepository repository;

    public void validar(Autor autor){
        if(existeAutorCadastrado(autor)){
            throw new RegistroDuplicadoException("Autor já cadastrado");
        }

    }

    private boolean existeAutorCadastrado(Autor autor){
        //Busca no banco de dados um possível autor com essas informações
        Optional<Autor> autorEncontrado = repository.findByNomeAndDataNascimentoAndNacionalidade(autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade());

        //Verifica se esse registro é novo ou já foi cadastrado no banco de dados
        if(autor.getId() == null){
            return autorEncontrado.isPresent();
        }

        return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }
}
