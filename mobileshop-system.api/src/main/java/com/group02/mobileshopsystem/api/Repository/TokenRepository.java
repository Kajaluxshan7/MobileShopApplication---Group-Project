package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByToken(String token);
  @Transactional
  @Modifying
  @Query("UPDATE Token c " +
          "SET c.confirmedAt = ?2 " +
          "WHERE c.token = ?1")
  int updateConfirmedAt(String token,
                        LocalDateTime confirmedAt);

  @Modifying
  @Query("DELETE FROM Token t WHERE t.user.id = ?1")
  int deleteTokenByUserId(int userId);
}
