package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityDuration extends BaseModel {


    @Enumerated(EnumType.STRING)
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
