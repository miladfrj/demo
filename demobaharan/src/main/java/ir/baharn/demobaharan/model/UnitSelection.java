package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.Entity;
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
    private UniversityDuration universityDuration;
}
