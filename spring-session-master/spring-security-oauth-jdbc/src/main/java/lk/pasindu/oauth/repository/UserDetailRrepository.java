package lk.pasindu.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.pasindu.oauth.modal.User;

public interface UserDetailRrepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String name);
}
