package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Admin;
import com.usa.ciclo3.reto4.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getList() {
        return adminRepository.findAll();
    }

    public Admin getById(Long id) {
        return adminRepository.findById(id).get();
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
    
    public Admin update(Admin admin){
        if (admin.getId() != null) {
            Optional<Admin> adminId = adminRepository.findById(admin.getId());
            
            if (!adminId.isEmpty()) {
                Admin adminBd = adminId.get();
                
                adminBd.setMail(admin.getMail());
                adminBd.setName(admin.getName());
                adminBd.setPassword(admin.getPassword());
                
                return adminRepository.save(adminBd);
                               
            } else {
                
                return admin;
            }
        }
        return admin;
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

}
