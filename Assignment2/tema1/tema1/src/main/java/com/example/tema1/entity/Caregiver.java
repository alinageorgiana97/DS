package com.example.tema1.entity;

import com.example.tema1.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "user_id",name = "fk1")})
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Caregiver{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "caregiver_id")
        private Long id;
        private String name;
        private Date birthDate;
        private String gender;
        private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User  user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="patient_id")
    private List<Patient>patients;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
