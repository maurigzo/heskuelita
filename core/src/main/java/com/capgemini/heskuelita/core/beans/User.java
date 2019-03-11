package com.capgemini.heskuelita.core.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class User extends Person{

    private LocalDate created;

    private LocalDate updated;

}
