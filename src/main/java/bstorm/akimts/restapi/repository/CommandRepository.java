package bstorm.akimts.restapi.repository;

import bstorm.akimts.restapi.models.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

}
