package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.*;
import ir.baharn.demobaharan.repository.TeacherRepository;
import ir.baharn.demobaharan.repository.UnitSelectionRepository;
import ir.baharn.demobaharan.repository.UniversityDurationRepository;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.UniversityDurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUniversityDurationService implements UniversityDurationService {

    @Autowired
    UniversityDurationRepository universityDurationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UnitSelectionRepository unitSelectionRepository;

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public List<UniversityDuration> getAll() {
        return universityDurationRepository.findAllUniversityDuration();
    }

    @Override
    public UniversityDuration save(UniversityDuration universityDuration) {
        return universityDurationRepository.save(universityDuration);
    }

    @Override
    public UniversityDuration findById(Long id) {
        return universityDurationRepository.findUniversityDurationById(id);
    }

    @Override
    public void deleteById(Long id) {
        universityDurationRepository.deleteById(id);
    }

    @Override
    public UnitSelection saveByUsername(String username, UnitSelection selection) {
        return null;
    }

}

