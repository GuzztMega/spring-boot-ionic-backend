package com.udemyspring.cursomc.cursomc.repositories;

import com.udemyspring.cursomc.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {



}
