package ir.baharn.demobaharan.model;

import ir.baharn.demobaharan.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends BaseModel {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String unitCount;
    @Column(nullable = false)
    private String courseCode;


}
