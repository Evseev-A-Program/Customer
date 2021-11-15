package repository;

import models.Addresses;
import models.PaidType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidTypeDao extends CrudRepository<PaidType, Long> {

}
