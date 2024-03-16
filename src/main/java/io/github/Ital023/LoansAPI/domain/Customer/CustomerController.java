package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer-loans")
public class CustomerController {

    @Autowired
    private CustomerLoanUseCase customerLoanUseCase;

    @PostMapping
    public ResponseEntity verifierCustomerLoans(@RequestBody CustomerEntity customer){
        CustomerLoansDTO customerLoansDTO = customerLoanUseCase.CustomerCases(customer);
        customerLoanUseCase.saveDatabase(customer);
        return ResponseEntity.ok().body(customerLoansDTO);
    }
}
