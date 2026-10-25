package com.example.hrm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeCreateDTO {
    private String fullName;
    private String email;
    private String department;
    private MultipartFile avatarFile;
}
