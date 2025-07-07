package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.UnitSelection;

import java.util.List;

public interface UnitSelectionService {

    List<UnitSelection> getAll();
    UnitSelection save(UnitSelection unitSelection);
}
