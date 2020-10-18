package com.teste.teste.repository;

import com.teste.teste.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NationRepository extends JpaRepository<Nation, Integer> {

    Optional<Nation> findOneById(Integer id);

    List<Nation> findAllByNameContains(String texto);

    Optional<Nation> findOneByIdAndDeletedIsFalse(Integer id);
}
