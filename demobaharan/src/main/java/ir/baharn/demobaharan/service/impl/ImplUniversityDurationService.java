package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.UniversityDuration;
import ir.baharn.demobaharan.repository.UniversityDurationRepository;
import ir.baharn.demobaharan.service.UniversityDurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUniversityDurationService implements UniversityDurationService {

    @Autowired
    UniversityDurationRepository universityDurationRepository;


    @Override
    public List<UniversityDuration> getAll() {
        return universityDurationRepository.findAll();
    }

    @Override
    public UniversityDuration save(UniversityDuration universityDuration) {
        return universityDurationRepository.save(universityDuration);
    }

    @Override
    public UniversityDuration findById(Long id) {
        return universityDurationRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        universityDurationRepository.deleteById(id);
    }
}
