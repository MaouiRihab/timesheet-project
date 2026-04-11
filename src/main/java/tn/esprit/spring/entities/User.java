package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   

    private String firstName; 
    private String lastName;
    private String username;      // <-- ajouté
    private String password;      // <-- ajouté

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(EnumType.STRING)
    private Role role; 

    public User() {}

    public User(String firstName, String lastName, String username, String password, Date dateNaissance, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.role = role;
    }

    public User(Long id, String firstName, String lastName, String username, String password, Date dateNaissance, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.role = role;
    }

    // ======= GETTERS =======
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName + "-v1"; }
    public String getUsername() { return username; }   // <-- ajouté
    public String getPassword() { return password; }   // <-- ajouté
    public Date getDateNaissance() { return dateNaissance; }
    public Role getRole() { return role; }

    // ======= SETTERS =======
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setUsername(String username) { this.username = username; }  // <-- ajouté
    public void setPassword(String password) { this.password = password; }  // <-- ajouté
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", username=" + username + ", dateNaissance=" + dateNaissance +
                ", role=" + role + "]";
    }
}
