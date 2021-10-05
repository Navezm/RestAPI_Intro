package bstorm.akimts.restapi.repository;

import bstorm.akimts.restapi.models.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
