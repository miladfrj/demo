package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    PersonDTO getById(Long id);
    PersonDTO save(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
    void delete(Long id);
}
