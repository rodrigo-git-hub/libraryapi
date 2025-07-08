package com.rodrigogustavo.Libraryapi.service;

import com.rodrigogustavo.Libraryapi.domain.Autor;
import com.rodrigogustavo.Libraryapi.exceptions.OperacaoNaoPermitidaException;
import com.rodrigogustavo.Libraryapi.repositories.AutorRepository;
import com.rodrigogustavo.Libraryapi.repositories.LivroRepository;
import com.rodrigogustavo.Libraryapi.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor //Cria um contrutor com os campos obrigatórios
public class AutorService {

    private final AutorRepository repository;
    private final AutorValidator validator;
    private final LivroRepository livroRepository;

    public Autor salvar(Autor autor){
        validator.validar(autor);
        return repository.save(autor);
    }

    public Optional<Autor> obterDetalhes(UUID id){

        return repository.findById(id);
    }

    public void deletar(Autor autor){
        if(possuiLivro(autor)){
            throw new OperacaoNaoPermitidaException("Não é permitido exclui auto que possui livro cadastrado");
        }
        repository.delete(autor);
    }

    public List<Autor> pesquisar(String nome, String nacionalidade){
        if (nome != null && nacionalidade != null){
            return repository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if (nome != null){
            return repository.findByNome(nome);
        }

        if (nacionalidade != null){
            return repository.findByNacionalidade(nacionalidade);
        }

        return repository.findAll();
    }

    public void atualizar(Autor autor) {
        if (autor.getId() == null){
            throw new IllegalArgumentException("Autor não existe");
        }
        validator.validar(autor);
        repository.save(autor);
    }

    public boolean possuiLivro(Autor autor){
        return livroRepository.existsByAutor(autor);
    }
}
