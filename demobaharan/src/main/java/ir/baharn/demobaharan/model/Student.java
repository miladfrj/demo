package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseModel {

    @Column(nullable = false)
    private String studentCode;
    @Column(nullable = false)
    private String proMajor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

}