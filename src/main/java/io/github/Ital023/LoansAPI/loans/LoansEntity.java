package io.github.Ital023.LoansAPI.loans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "loans")
@Table(name = "loans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansEntity {
    @NotBlank
    private String type;
    @NotNull
    private int interest_rate;
}
