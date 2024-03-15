package io.github.Ital023.LoansAPI.loans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansEntity {
    private String type;
    private int interest_rate;
}
