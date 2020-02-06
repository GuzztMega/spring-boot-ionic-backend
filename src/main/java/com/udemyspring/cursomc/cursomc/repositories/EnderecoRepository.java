package com.udemyspring.cursomc.cursomc.repositories;

import com.udemyspring.cursomc.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {



}
