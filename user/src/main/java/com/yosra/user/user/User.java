package com.yosra.user.user;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String phoneNumber;
    private String email;

}


