package com.rodrigogustavo.Libraryapi.repositories;

import com.rodrigogustavo.Libraryapi.domain.Autor;
import com.rodrigogustavo.Libraryapi.domain.Livro;
import com.rodrigogustavo.Libraryapi.enums.GeneroLivro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvar(){
        Livro livro = new Livro();
        livro.setIsbn("8767-9743");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Negócio da Péh");
        livro.setPreco(new BigDecimal(200));
        livro.setDataPublicacao(LocalDate.of(2014,8,4));

        Autor autor = autorRepository.findById(UUID.fromString("546c8d54-2bca-4c3c-be9b-dd1b779cf0f7")).orElse(null);

        livro.setAutor(autor);

        livroRepository.save(livro);
    }

    @Test
    void salvarCascateTest(){
        Livro livro = new Livro();
        livro.setIsbn("8767-9743");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Negócio da Péh");
        livro.setPreco(new BigDecimal(200));
        livro.setDataPublicacao(LocalDate.of(2014,8,4));

        Autor autor = new Autor();
        autor.setNome("Jessica Nayana Silva");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1989,11,23));

        livro.setAutor(autor);

        livroRepository.save(livro);
    }

    @Test
    void buscarPorIdTest(){
        Livro livro = livroRepository.findById(UUID.fromString("223353f1-c2bb-43b6-80e5-e75243d118fa")).orElse(null);
        System.out.println(livro.getId() + " - " + livro.getTitulo() + " - " + livro.getAutor().getNome());
    }

    @Test
    void atualizarTest(){
        Livro livro = livroRepository.findById(UUID.fromString("58dd8ad3-afd6-4e84-bdfd-e072f3105e3f")).orElse(null);

//        Autor autor = autorRepository.findById(UUID.fromString("1c6395ec-ae7d-4a48-a47c-ab306fe9f141")).orElse(null);
//
//        livro.setAutor(autor);

        livro.setTitulo("O amor amado");
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setPreco(new BigDecimal(459));

        livroRepository.save(livro);
    }

    @Test
    void buscarTodosTest(){
        List<Livro> list = livroRepository.findAll();
        for(Livro l: list){
            System.out.println("Codigo: "
                    + l.getId()
                    + " Título: "
                    + l.getTitulo()
                    + " Genero: "
                    + l.getGenero()
                    + " Preço: "
                    + l.getPreco()
                    + " Codigo do Autor: "
                    + l.getAutor().getId()
                    + " Nome do Autor "
                    + l.getAutor().getNome()
            );
        }
    }
    @Test
    void deletarTeste(){
        Livro livro = livroRepository.findById(UUID.fromString("3a16c46b-8230-438c-97d7-4df96a8968b2")).orElse(null);

        livro.setAutor(null);

        livroRepository.save(livro);

        livroRepository.deleteById(UUID.fromString("3a16c46b-8230-438c-97d7-4df96a8968b2"));

    }

}