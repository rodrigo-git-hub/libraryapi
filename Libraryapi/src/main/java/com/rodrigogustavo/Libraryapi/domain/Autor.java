package com.rodrigogustavo.Libraryapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="autor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "livros")
@EqualsAndHashCode(of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL) //Esse atributo não existe no banco de dados, ao utilizar o oneToMany com o mappedBy, estamos apenas fazendo o relacionamento dentro do objeto indicando que varios livros podem pertencer a um autor. Com esse atributo podemos pela classe autor carregar uma lista de livros dele sem precisar carregar uma instancia da classe livros filtrando pelo autor
    private List<Livro> livros;
}
