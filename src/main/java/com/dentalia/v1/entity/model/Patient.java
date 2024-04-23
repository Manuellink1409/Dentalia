package com.dentalia.v1.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30, message = "The name cannot exceed 30 characters.")
    @NotNull
    private String name;
    
    @Size(max = 30, message = "The lastname cannot exceed 30 characters.")
    @NotNull
    private String lastname;

    @Column(unique = true)
    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Pattern(regexp="\\d{10}", message="Invalid phone number")
    private String phone;

    @Pattern(regexp="\\d{10}", message="Invalid phone number")
    private String emergency_phone;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") 
    private User doctor_assigned;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        ENABLED, DISABLED
    }
}
