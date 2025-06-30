package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "power")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseModel {
    @Column(nullable = false , unique = true)
    private String title;

}
