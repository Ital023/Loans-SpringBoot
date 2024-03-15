package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoansDTO {
    private String name;
    List<LoansEntity> loans = new ArrayList<>();
}
