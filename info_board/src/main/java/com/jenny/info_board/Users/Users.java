package com.jenny.info_board.Users;
import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Users")
public class User {

    @Id
    private int user_id;

    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private String phone_number;
    private char gender;
    private int job_code;
    private String nationality;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Getters and setters...
}