package ir.baharn.demobaharan.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String nationalCode;
    private String location;
    private String personnelCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Long departmentId;
    private String departmentTitle;

}
