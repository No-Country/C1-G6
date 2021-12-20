package io.orderup.repositories;

import io.orderup.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    Optional<Table> findById(long id);
    Table getById(long id);
}
