package com.group02.mobileshopsystem.api.Model;

import com.group02.mobileshopsystem.api.Token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(name = "email",columnNames ={"email"} )})
        public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private int mobileNo;
  private String address;
  private boolean verified;
  @Enumerated(EnumType.STRING)
  private UserRole userRole;
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;
  public User(String firstname, String lastname, String email, String password, int mobileNo,String address, boolean verified, UserRole userRole, List<Token> tokens) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.mobileNo = mobileNo;
    this.address = address;
    this.verified = verified;
    this.userRole = userRole;
    this.tokens = tokens;

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
    return Collections.singleton(authority);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public int getMobileNo() {
    return mobileNo;
  }

  public String getAddress() {
    return address;
  }

  public boolean isVerified() {
    return verified;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public List<Token> getTokens() {
    return tokens;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return verified;
  }
}
