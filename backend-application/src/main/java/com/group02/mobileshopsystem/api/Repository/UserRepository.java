package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
  boolean existsByEmail(String email);
  @Transactional
  @Modifying
  @Query("UPDATE User a " +
          "SET a.verified = TRUE WHERE a.email = ?1")
  int verifyUser(String email);
  @Query("SELECT verified FROM User WHERE email = ?1")
  boolean isVerifiedUser(String email);
}
