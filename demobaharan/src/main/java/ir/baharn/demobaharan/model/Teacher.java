package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher extends BaseModel {

    @Column(nullable = false)
    private String teacherCode;
    @Column(nullable = false)
    private String proMajor;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;


}

