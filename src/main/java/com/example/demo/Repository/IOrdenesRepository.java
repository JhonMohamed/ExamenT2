package com.example.demo.Repository;

import com.example.demo.Model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenesRepository extends JpaRepository<Ordenes,Long> {


}
