package com.dentalia.v1.entity.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="medical_monitoring")
public class Monitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id") 
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "procedure_id", referencedColumnName = "id") 
    private Procedure procedure;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Tooth tooth;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        ENABLED, DISABLED
    }

    public enum Tooth {
        INCISOR_UPPER_RIGHT_1,
        INCISOR_UPPER_RIGHT_2,
        INCISOR_UPPER_LEFT_1,
        INCISOR_UPPER_LEFT_2,
        INCISOR_LOWER_RIGHT_1,
        INCISOR_LOWER_RIGHT_2,
        INCISOR_LOWER_LEFT_1,
        INCISOR_LOWER_LEFT_2,
        CANINE_UPPER_RIGHT,
        CANINE_UPPER_LEFT,
        CANINE_LOWER_RIGHT,
        CANINE_LOWER_LEFT,
        PREMOLAR_UPPER_RIGHT_1,
        PREMOLAR_UPPER_RIGHT_2,
        PREMOLAR_UPPER_LEFT_1,
        PREMOLAR_UPPER_LEFT_2,
        PREMOLAR_LOWER_RIGHT_1,
        PREMOLAR_LOWER_RIGHT_2,
        PREMOLAR_LOWER_LEFT_1,
        PREMOLAR_LOWER_LEFT_2,
        MOLAR_UPPER_RIGHT_1,
        MOLAR_UPPER_RIGHT_2,
        MOLAR_UPPER_RIGHT_3,
        MOLAR_UPPER_RIGHT_4,
        MOLAR_UPPER_LEFT_1,
        MOLAR_UPPER_LEFT_2,
        MOLAR_UPPER_LEFT_3,
        MOLAR_UPPER_LEFT_4,
        MOLAR_LOWER_RIGHT_1,
        MOLAR_LOWER_RIGHT_2,
        MOLAR_LOWER_RIGHT_3,
        MOLAR_LOWER_RIGHT_4,
        MOLAR_LOWER_LEFT_1,
        MOLAR_LOWER_LEFT_2,
        MOLAR_LOWER_LEFT_3,
        MOLAR_LOWER_LEFT_4
    }


}
