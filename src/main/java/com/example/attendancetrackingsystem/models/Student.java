package com.example.attendancetrackingsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column( nullable = false,length = 50)
    private String firstName;
    @Column( nullable = false,length = 50)
    private String lastName;
    @Column( nullable = false,length = 100)
    private String email;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean checkedIn = false;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @ManyToMany(mappedBy = "students")
    private List<Session> sessions = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;
////
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
}