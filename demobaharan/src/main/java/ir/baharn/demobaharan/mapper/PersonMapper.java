package ir.baharn.demobaharan.mapper;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.model.Department;
import ir.baharn.demobaharan.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDTO toDto(Person person) {
        if (person == null)
            return null;

        return PersonDTO.builder()
                .id(person.getId())
                .username(person.getUsername())
                .password(person.getPassword())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .nationalCode(person.getNationalCode())
                .location(person.getLocation())
                .personnelCode(person.getPersonnelCode())
                .birthDate(person.getBirthDate())
                .departmentTitle(person.getDepartment() != null ? person.getDepartment().getTitle() : null)
                .build();

    }


    public Person toEntity(PersonDTO dto) {
        if (dto == null) return null;

        Person person = Person.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .nationalCode(dto.getNationalCode())
                .location(dto.getLocation())
                .personnelCode(dto.getPersonnelCode())
                .birthDate(dto.getBirthDate())
                .build();

        if (dto.getDepartmentId() != null) {
            Department department = new Department();
            department.setId(dto.getDepartmentId());
            person.setDepartment(department);
        }
        return person;
    }
}
