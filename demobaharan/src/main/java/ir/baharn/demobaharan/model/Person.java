package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Person extends BaseModel {


    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false , unique = true)
    private String nationalCode;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false , unique = true)
    private String personnelCode;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(nullable = false)
    private String lastDegree;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
