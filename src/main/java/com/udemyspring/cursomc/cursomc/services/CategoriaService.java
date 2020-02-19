package com.udemyspring.cursomc.cursomc.services;

import com.udemyspring.cursomc.cursomc.domain.Categoria;
import com.udemyspring.cursomc.cursomc.domain.Cliente;
import com.udemyspring.cursomc.cursomc.dto.CategoriaDTO;
import com.udemyspring.cursomc.cursomc.repositories.CategoriaRepository;
import com.udemyspring.cursomc.cursomc.services.exceptions.DataIntegrityException;
import com.udemyspring.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Categoria newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

   public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch(DataIntegrityViolationException dive) {
            throw new DataIntegrityException("Não é possivel excluir esta Categoria, pois ela possui produtos cadastrados.");
       }
   }

   public List<Categoria> findAll(){
        return repo.findAll();
   }

   public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
       return repo.findAll(pageRequest);
   }

   public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome());
   }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
    }
}
