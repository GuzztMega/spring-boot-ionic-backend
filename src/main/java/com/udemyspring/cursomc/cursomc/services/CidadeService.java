package com.udemyspring.cursomc.cursomc.services;

import com.udemyspring.cursomc.cursomc.domain.Cidade;
import com.udemyspring.cursomc.cursomc.domain.Estado;
import com.udemyspring.cursomc.cursomc.repositories.CidadeRepository;
import com.udemyspring.cursomc.cursomc.repositories.EstadoRepository;
import com.udemyspring.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public List<Cidade> findByEstado(Integer estadoId){
        return repo.findCidades(estadoId);
    }
}
