package io.github.Ital023.LoansAPI.domain.Customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;


@Entity(name = "customer")
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private int age;

    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @NotNull
    private double income;

    @NotBlank
    @Length(min = 2,max = 2, message = "A senha deve conter 2 letras")
    private String location;

}