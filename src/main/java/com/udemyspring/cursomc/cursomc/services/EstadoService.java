package com.udemyspring.cursomc.cursomc.services;

import com.udemyspring.cursomc.cursomc.domain.Estado;
import com.udemyspring.cursomc.cursomc.repositories.EstadoRepository;
import com.udemyspring.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public Estado find(Integer id){
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " +id+ ", Tipo: " + Estado.class.getName()
        ));
    }

    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }
}
