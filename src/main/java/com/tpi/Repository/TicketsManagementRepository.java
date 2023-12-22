package com.tpi.Repository;

import com.tpi.Model.TicketsManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketsManagementRepository extends JpaRepository<TicketsManagement, Long> {
    Optional<TicketsManagement> findByEmail(String email);
}
