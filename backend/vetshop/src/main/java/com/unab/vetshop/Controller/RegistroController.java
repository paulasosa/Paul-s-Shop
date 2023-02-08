package com.unab.vetshop.Controller;


import com.unab.vetshop.Models.Registro;
import com.unab.vetshop.Dao.RegistroDao;
import com.unab.vetshop.Service.RegistroService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private RegistroDao registroDao; 
    @Autowired
    private RegistroService registroService;
    @PostMapping(value="/registro")
    public ResponseEntity<Registro> agregar(@RequestBody Registro registro){        
        Registro obj = registroService.save(registro);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Registro> eliminar(@PathVariable String id){ 
        Registro obj = registroService.findById(id); 
        if(obj!=null) 
            registroService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<Registro> editar(@RequestBody Registro registro){ 
        Registro obj = registroService.findById(registro.getId_registro()); 
        if(obj!=null) { 
            //obj.setNombre_registro(registro.getNombre_registro());
            //obj.setClave_registro(registro.getClave_registro());
            registroService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list") 
    public List<Registro> consultarTodo(){
        return registroService.findAll(); 
    }
    @GetMapping("/list/{id}") 
    public Registro consultaPorId(@PathVariable String id){ 
        return registroService.findById(id); 
    }
}