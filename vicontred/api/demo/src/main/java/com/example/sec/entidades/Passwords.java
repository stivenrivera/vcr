package com.example.sec.entidades;

import javax.persistence.*;

@Entity
@Table(schema = "dbusers", name = "passwords")
public class Passwords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_viejo")
    private String passwordViejo;

    @Column(name = "reg_security")
    private String regSecurity;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPasswordViejo() { return passwordViejo; }
    public void setPasswordViejo(String passwordViejo) { this.passwordViejo = passwordViejo; }

    public String getRegSecurity() { return regSecurity; }
    public void setRegSecurity(String regSecurity) { this.regSecurity = regSecurity; }
}
