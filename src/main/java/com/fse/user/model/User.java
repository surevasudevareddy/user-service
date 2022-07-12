package com.fse.user.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor()
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "skilltracker")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "associate_id", nullable = false)
    private String associateId;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "mobile",nullable = false)
    private long mobile;
    @Column(name = "create_ts", nullable = false)
    private Date createTs;
    @Column(name = "update_ts", nullable = false)
    private Date updateTs;

}
