package com.unab.vetshop.Controller;


import com.unab.vetshop.Models.Login;
import com.unab.vetshop.Dao.LoginDao;
import com.unab.vetshop.Service.LoginService;
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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginDao loginDao; 
    @Autowired
    private LoginService loginService;
    @PostMapping(value="/")
    public ResponseEntity<Login> agregar(@RequestBody Login login){        
        Login obj = loginService.save(login);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Login> eliminar(@PathVariable String id){ 
        Login obj = loginService.findById(id); 
        if(obj!=null) 
            loginService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<Login> editar(@RequestBody Login login){ 
        Login obj = loginService.findById(login.getId_login()); 
        if(obj!=null) { 
            //obj.setNombre_login(login.getNombre_login());
            //obj.setClave_login(login.getClave_login());
            loginService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list") 
    public List<Login> consultarTodo(){
        return loginService.findAll(); 
    }
    @GetMapping("/list/{id}") 
    public Login consultaPorId(@PathVariable String id){ 
        return loginService.findById(id); 
    }
}