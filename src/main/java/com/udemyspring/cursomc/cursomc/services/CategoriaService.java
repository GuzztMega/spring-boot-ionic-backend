package com.udemyspring.cursomc.cursomc.services;

import com.udemyspring.cursomc.cursomc.domain.Categoria;
import com.udemyspring.cursomc.cursomc.repositories.CategoriaRepository;
import com.udemyspring.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " +id+ ", Tipo: " + Categoria.class.getName()
        ));
   }

   public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
   }

   public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
   }
}
