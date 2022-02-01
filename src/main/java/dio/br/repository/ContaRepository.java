package dio.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.br.model.Conta;


public interface ContaRepository extends JpaRepository <Conta,Long>{

}
