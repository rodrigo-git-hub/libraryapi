package com.rodrigogustavo.Libraryapi.domain;

import com.rodrigogustavo.Libraryapi.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.jpa.internal.util.PessimisticNumberParser;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
//@Data => Essa annotation incorpora as annotations: @Getter @Setter @EqualsAndHashCode @RequiredArgsContructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
@ToString(exclude = "autor")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private GeneroLivro genero;

    @Column(precision = 18, scale = 2) //mapeamento do campo preço para definir que haverá 18 digitos sendo os dois ultimos separados por virgula
    private BigDecimal preco;

    @ManyToOne // Many => livros (refere-se a classe), One => Autor (Refere-se o relacionamento) | 1 autor para muitos livros
    @JoinColumn(name = "id_autor")
    private Autor autor;

}
