package com.ruinivan.edufincore.application.gateway;

import com.ruinivan.edufincore.domain.model.Student;
import java.util.Optional;

public interface StudentGateway {
    
    // Contrato: Recebo um Aluno do Domínio e devolvo um Aluno do Domínio salvo.
    Student save(Student student);
    
    // Contrato: Busco por CPF e retorno um Optional (pode não existir).
    Optional<Student> findByCpf(String cpf);
    
    // Contrato: Apenas verifico se existe.
    boolean existsByCpf(String cpf);
}