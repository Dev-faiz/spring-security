package com.app.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.MyUser;

public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
	
	Optional<MyUser> findMyUserByUsername(String username );

}
