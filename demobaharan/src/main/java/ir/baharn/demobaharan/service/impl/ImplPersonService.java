package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.mapper.PersonMapper;
import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.repository.PersonRepository;
import ir.baharn.demobaharan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplPersonService implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDto).orElse(null);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        if (personDTO.getId() == null) {
            throw new IllegalArgumentException("id can not be null");
        }

        return personRepository.findById(personDTO.getId()).map(existingPerson -> {
                    existingPerson.setUsername(personDTO.getUsername());
                    existingPerson.setPassword(personDTO.getPassword());
                    existingPerson.setFirstName(personDTO.getFirstName());
                    existingPerson.setLastName(personDTO.getLastName());
                    existingPerson.setEmail(personDTO.getEmail());
                    existingPerson.setNationalCode(personDTO.getNationalCode());
                    existingPerson.setLocation(personDTO.getLocation());
                    existingPerson.setPersonnelCode(personDTO.getPersonnelCode());
                    existingPerson.setBirthDate(personDTO.getBirthDate());
                    return personMapper.toDto(personRepository.save(existingPerson));
                })
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Override
    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person not found");
        }
        personRepository.deleteById(id);
    }


}
