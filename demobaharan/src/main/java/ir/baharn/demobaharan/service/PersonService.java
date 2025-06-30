package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.model.Person;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    PersonDTO getById(Long id);
    PersonDTO save(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
    void delete(Long id);

    Person getEntityById(Long id);
}
