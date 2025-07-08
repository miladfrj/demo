package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.UniversityDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityDurationRepository extends JpaRepository<UniversityDuration, Long> {
}
