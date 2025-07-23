package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.UnitSelection;

import java.util.List;

public interface UnitSelectionService {

    UnitSelection save(UnitSelection selection);

    List<UnitSelection> findAll();

    List<UnitSelection> getSelectionsByStudent(Long studentId);

    void saveByUsername(String username, UnitSelection unitSelection);

    Object getSelectionsByTeacherUsername(String username);
}
