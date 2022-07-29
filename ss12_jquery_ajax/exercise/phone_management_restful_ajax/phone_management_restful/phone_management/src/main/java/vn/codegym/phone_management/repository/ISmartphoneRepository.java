package vn.codegym.phone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.phone_management.model.Smartphone;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
