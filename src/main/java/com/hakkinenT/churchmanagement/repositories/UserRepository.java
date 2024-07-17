package com.hakkinenT.churchmanagement.repositories;

import com.hakkinenT.churchmanagement.models.entities.User;
import com.hakkinenT.churchmanagement.models.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = """
			SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority
			FROM tb_user
			INNER JOIN tb_role ON tb_role.id = tb_user.role_id
			WHERE tb_user.email = :email
		""")
    UserDetailsProjection searchUserAndRolesByEmail(String email);
}
