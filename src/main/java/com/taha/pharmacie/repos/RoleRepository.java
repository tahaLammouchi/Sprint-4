package com.taha.pharmacie.repos;

import com.taha.pharmacie.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
