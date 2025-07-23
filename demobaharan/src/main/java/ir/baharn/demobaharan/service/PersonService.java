package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Role;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();

    PersonDTO getById(Long id);

    PersonDTO save(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO);

    void delete(Long id);

    Person getEntityById(Long id);

    List<PersonDTO> getPersonsByRole(Role role);

    List<PersonDTO> getPersonsByRoleSafe(String roleParam);

    // String getPersonRole(Person personDTO);

    String getPersonRoleByEntity(Person person);

    List<PersonDTO> getAllStudents();

    List<PersonDTO> getAllTeachers();
}
