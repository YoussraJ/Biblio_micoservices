package com.yosra.Emprunt.emprunt;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "emprunts")
public class Emprunt {
    @Id
    private int id;
    private int id_user;
    private int id_livre;
    private LocalDate borrow_date; // Date of borrowing
    private LocalDate return_date; // Date of return

}


