package com.mais_saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mais_saude.model.UsuariosModel;
@Repository
public interface UsuariosReposiroty extends JpaRepository<UsuariosModel, Long>{

}
