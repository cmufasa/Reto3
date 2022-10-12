package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Admin;
import com.usa.ciclo3.reto3.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/Admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    public List<Admin> getAdminList(){
        return adminService.getList();
    }
    
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable("id") Long id){
        return adminService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertAdmin(@RequestBody Admin admin){
       adminService.save(admin);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdmin(@PathVariable("id") Long id){
       adminService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
