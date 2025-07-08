package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.UniversityDuration;

import java.util.List;

public interface UniversityDurationService {

    List<UniversityDuration> getAll();

    UniversityDuration save(UniversityDuration universityDuration);

    UniversityDuration findById(Long id);

    void deleteById(Long id);
}
