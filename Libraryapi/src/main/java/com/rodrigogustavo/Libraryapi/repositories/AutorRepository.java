package com.rodrigogustavo.Libraryapi.repositories;

import com.rodrigogustavo.Libraryapi.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
