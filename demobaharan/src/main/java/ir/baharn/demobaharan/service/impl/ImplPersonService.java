package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.mapper.PersonMapper;
import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.repository.PersonRepository;
import ir.baharn.demobaharan.repository.StudentRepository;
import ir.baharn.demobaharan.repository.TeacherRepository;
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

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAllPersons()
                .stream()
                .map(person -> {
                    PersonDTO dto = personMapper.toDto(person);
                    dto.setRole(getPersonRoleByEntity(person));
                    return dto;
                })
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

    @Override
    public Person getEntityById(Long id) {
        return personRepository.findById(id).orElse(null);
    }


    @Override
    public List<PersonDTO> getPersonsByRole(Role role) {
        switch (role) {
            case STUDENT:
                return getAllStudents();
            case TEACHER:
                return getAllTeachers();
            default:
                return getAll();
        }
    }

    @Override
    public List<PersonDTO> getPersonsByRoleSafe(String roleParam) {
        try {
            Role role = Role.valueOf(roleParam);
            return getPersonsByRole(role);
        } catch (IllegalArgumentException | NullPointerException e) {
            return getAll();
        }
    }


    @Override
    public String getPersonRoleByEntity(Person person) {
        if (studentRepository.existsByPerson(person)) return "STUDENT";
        if (teacherRepository.existsByPerson(person)) return "TEACHER";
        return "ADMIN";
    }


    @Override
    public List<PersonDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> personMapper.toDto(student.getPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacher -> personMapper.toDto(teacher.getPerson()))
                .collect(Collectors.toList());
    }


}
