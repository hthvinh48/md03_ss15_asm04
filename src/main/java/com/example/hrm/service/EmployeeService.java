package com.example.hrm.service;

import com.example.hrm.dto.req.EmployeeCreateDTO;
import com.example.hrm.entity.Employee;
import com.example.hrm.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CloudinaryService cloudinaryService;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeCreateDTO request) {
        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setDepartment(request.getDepartment());
        employee.setEmail(request.getEmail());

        MultipartFile file = request.getAvatarFile();
        if (file != null && !file.isEmpty()) {
            employee.setAvatarUrl(cloudinaryService.uploadImage(file));
        }

        return employeeRepository.save(employee);
    }
}
