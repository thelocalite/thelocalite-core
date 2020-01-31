package core.security.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * Auth
 */
@Entity
public class Auth implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NaturalId
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Reset Token Related
    private String reset_password_token;
    private Long reset_password_token_expiry;

    // GeoLocation Related
    private String address;
    private String contactNumber;

    private Double latitude;
    private Double longitude;

    // Profile
    private String imageUrl;
    private Boolean isActive;
    private Boolean isBlocked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(this.role.name()));
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isBlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.isBlocked;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            ", reset_password_token='" + getReset_password_token() + "'" +
            ", reset_password_token_expiry='" + getReset_password_token_expiry() + "'" +
            ", address='" + getAddress() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", isActive='" + isActive + "'" +
            ", isBlocked='" + isBlocked + "'" +
            "}";
    }

}