package com.rodrigogustavo.Libraryapi.repositoryTest;

import com.rodrigogustavo.Libraryapi.domain.Autor;
import com.rodrigogustavo.Libraryapi.domain.Livro;
import com.rodrigogustavo.Libraryapi.enums.GeneroLivro;
import com.rodrigogustavo.Libraryapi.repositories.AutorRepository;
import com.rodrigogustavo.Libraryapi.repositories.LivroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Autowired
//    private LivroRepository livroRepository;
//
//    @Test
//    public void salvar(){
//        Autor autor = new Autor();
//        autor.setNome("Teste da Silva Santos");
//        autor.setNacionalidade("Brasileiro");
//        autor.setDataNascimento(LocalDate.of(1999,9,3));
//
//        var obj = autorRepository.save(autor);
//
//        System.out.println("Objeto salvo com sucesso " + obj);
//    }
//
//    @Test
//    public void atualizar(){
//        // 91db3c16-0240-4fb2-a91a-3bd5d8e7b5ef
//
//        var id = UUID.fromString("546c8d54-2bca-4c3c-be9b-dd1b779cf0f7");
//        Optional<Autor> possivelAutor = autorRepository.findById(id);
//
//        if(possivelAutor.isPresent()){
//            Autor autorEncontrado = possivelAutor.get();
//            autorEncontrado.setDataNascimento(LocalDate.of(1993,8,28));
//            System.out.println("Autor atualizado com sucesso " + autorEncontrado.getNome());
//            autorRepository.save(autorEncontrado);
//        }
//    }
//
//    @Test
//    public void listarTodosTest(){
//        List<Autor> autorList = autorRepository.findAll();
//        for(Autor autor: autorList){
//            System.out.println(" - " + autor.getId() + " - " + autor.getNome());
//        }
//    }
//
//    @Test
//    public void deletarTest(){
//        var id = UUID.fromString("bd8487f5-1c9b-4785-9a0a-304dc42b7c74");
//        Optional<Autor> possivelAutor = autorRepository.findById(id);
//
//        if(possivelAutor.isPresent()){
//            Autor autorEncontrado = possivelAutor.get();
//            autorRepository.delete(autorEncontrado);
//            System.out.println("Autor deletado com sucesso");
//        }
//    }
//
//    @Test
//    public void deletarPorIdTest(){
//        var id = UUID.fromString("bd8487f5-1c9b-4785-9a0a-304dc42b7c74");
//        autorRepository.deleteById(id);
//    }
//
//    @Test
//    public void countTest(){
//        System.out.println("Numero de registro: " + autorRepository.count());
//    }
//
//    @Test
//    public void salvarAutorComLivros(){
//        Autor autor = new Autor();
//        autor.setNome("Jose Egidio da Silva");
//        autor.setNacionalidade("Brasileiro");
//        autor.setDataNascimento(LocalDate.of(1962,11,5));
//
//        Livro livro1 = new Livro();
//        livro1.setIsbn("6273-9034");
//        livro1.setGenero(GeneroLivro.BIOGRAFIA);
//        livro1.setTitulo("Eu vi o sol nascer");
//        livro1.setPreco(new BigDecimal(750));
//        livro1.setDataPublicacao(LocalDate.of(2016, 6, 12));
//        livro1.setAutor(autor);
//
//        Livro livro2 = new Livro();
//        livro2.setIsbn("6475-9637");
//        livro2.setGenero(GeneroLivro.FICCAO);
//        livro2.setTitulo("Ficcionado pelas coisas ficticias");
//        livro2.setPreco(new BigDecimal(751));
//        livro2.setDataPublicacao(LocalDate.of(2017, 7, 16));
//        livro2.setAutor(autor);
//
//        autor.setLivros(new ArrayList<>());
//        autor.getLivros().add(livro1);
//        autor.getLivros().add(livro2);
//
//        autorRepository.save(autor);
//        livroRepository.saveAll(autor.getLivros());
//    }
//
//    @Test
//    public void listarLivrosAutor(){
//        UUID id = UUID.fromString("087948db-583e-46af-9dcb-986fc59c17ea");
//        Autor autor = autorRepository.findById(id).orElse(null);
//
//        //obter a lista de livros desse autor
//        List<Livro> list = livroRepository.findByAutor(autor);
//        autor.setLivros(list);
//
//        //percorrer a lista imprimindo os livros
//        autor.getLivros().forEach(System.out::println);
//    }
//



}
