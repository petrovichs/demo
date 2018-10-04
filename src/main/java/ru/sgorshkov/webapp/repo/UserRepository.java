package ru.sgorshkov.webapp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.sgorshkov.webapp.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Page<UserEntity> findAll(Pageable pageable);

}
