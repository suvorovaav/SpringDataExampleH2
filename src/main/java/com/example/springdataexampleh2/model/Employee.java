package com.example.springdataexampleh2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

// Поле, находящееся под аннотацией Transient, не имеет отображения в БД

@Setter
@Getter
@Entity // Entity говорит о том, что этот класс - сущность, которую надо сохранить в БД
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false)
    private Long id;


//    @Column(name = "role", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Role role;

    private String name;
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
