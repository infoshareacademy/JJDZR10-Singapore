package com.singapore.TripPlaner.Model.User;

import com.singapore.TripPlaner.Model.Opinion;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Component
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    @NotNull
    @NotEmpty
    @Column(name = "name")
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole userRole;
    @ColumnDefault("false")
    private Boolean locked;
    @ColumnDefault("true")
    private Boolean enabled;
    @OneToMany (mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Opinion> opinions = new ArrayList<>();

    public User(String login, String name, String email, String password, UserRole userRole, Boolean locked, Boolean enabled) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.locked = false;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
