package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.UnitSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitSelectionRepository extends JpaRepository<UnitSelection, Long> {

}
