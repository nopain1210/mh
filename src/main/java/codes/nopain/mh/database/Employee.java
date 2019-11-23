package codes.nopain.mh.database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private long salary;

    @Column(name = "coe")
    private float coe;

    @Column(name = "pay")
    private double pay;
}
