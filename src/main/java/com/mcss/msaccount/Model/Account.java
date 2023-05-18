package com.mcss.msaccount.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @NonNull
    String surname;

    Double balance;

    @ElementCollection
    List<Long> tickets;

}
