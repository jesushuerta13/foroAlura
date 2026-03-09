package com.foroAlura.foroAlura.repository;

import com.foroAlura.foroAlura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import com.foroAlura.foroAlura.entity.Topico;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

}
