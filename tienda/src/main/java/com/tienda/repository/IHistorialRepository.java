package com.tienda.repository;

import com.tienda.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {}
