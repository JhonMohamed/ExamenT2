package com.example.demo.Repository;

import com.example.demo.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrosRepository extends JpaRepository<Libros,Long> {

}
