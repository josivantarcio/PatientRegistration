package com.jtarcio.cadastro.pessoas.medicos.entities;

import com.jtarcio.cadastro.pessoas.pacientes.entities.PatientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String crm;

    // um medico para varios pacientes
    @OneToMany(mappedBy = "doctor")
    private List<PatientEntity> patients;

}
