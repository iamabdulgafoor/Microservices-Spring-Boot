package com.abdul.springboothibernate.studentto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_TABLE")
public class StudentTo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name = "STD_ROLLNO")
    private Integer stdRollNo;
    @Column(name = "STD_NAME")
    private String stdName;
}