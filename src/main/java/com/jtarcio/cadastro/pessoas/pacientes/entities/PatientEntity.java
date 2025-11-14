package com.jtarcio.cadastro.pessoas.pacientes.entities;

import com.jtarcio.cadastro.pessoas.medicos.entities.DoctorEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pacientes")
public class PatientEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;


    public PatientEntity() {
    }

    public PatientEntity(String name, Integer age, String email, DoctorEntity doctor) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PatientEntity{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", email='" + email + '\'' + '}';
    }
}
