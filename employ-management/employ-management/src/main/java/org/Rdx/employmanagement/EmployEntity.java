package org.Rdx.employmanagement;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class EmployEntity {
    private Long id;
    private String name;
    private String phNo;
    private String email;
}
