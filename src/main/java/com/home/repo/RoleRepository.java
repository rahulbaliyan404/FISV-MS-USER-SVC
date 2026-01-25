package com.home.repo;

import com.home.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
    Optional<RolesEntity> findByRoleName(String roleName);

}
