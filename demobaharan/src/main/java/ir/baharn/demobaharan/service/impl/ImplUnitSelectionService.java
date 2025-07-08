package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.UnitSelection;
import ir.baharn.demobaharan.repository.UnitSelectionRepository;
import ir.baharn.demobaharan.service.UnitSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUnitSelectionService implements UnitSelectionService {

    @Autowired
    private UnitSelectionRepository unitSelectionRepository;

    @Override
    public UnitSelection save(UnitSelection selection) {
        return unitSelectionRepository.save(selection);
    }
    @Override
    public List<UnitSelection> findAll() {
        return unitSelectionRepository.findAll();
    }

    @Override
    public List<UnitSelection> getSelectionsByStudent(Long studentId) {
        return unitSelectionRepository.findByStudent_id(studentId);
    }
}
