package bstorm.akimts.restapi.repository;

import bstorm.akimts.restapi.models.entity.CommandLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLine, Long> {

}
