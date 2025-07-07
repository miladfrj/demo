package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnitSelection extends BaseModel {
    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @Enumerated(EnumType.STRING)
    private Duration duration;
}
