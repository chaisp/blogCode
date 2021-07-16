package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.po.Manager;
import com.example.demo.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public void saveManger(ManagerDto managerDto) {
        Manager manager = managerDto.toEntity();
        managerRepository.save(manager);
    }

    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }

    public ManagerDto getManagerById(Long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isPresent()) {
            return new ManagerDto(manager.get());
        } else {
            throw new RuntimeException("manager not exist");
        }
    }
}
