package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer-loans")
public class CustomerController {

    @Autowired
    private CustomerLoanUseCase customerLoanUseCase;


    @GetMapping("/{id}")
    public ResponseEntity getCustomerLoans(@PathVariable UUID id){
       return ResponseEntity.ok().body(customerLoanUseCase.getCustomer(id));
    }

    @PostMapping
    public ResponseEntity verifierCustomerLoans(@RequestBody @Valid CustomerEntity customer){
        CustomerLoansDTO customerLoansDTO = customerLoanUseCase.CustomerCases(customer);
        customerLoanUseCase.saveDatabase(customer);
        return ResponseEntity.ok().body(customerLoansDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable UUID id){
        customerLoanUseCase.deleteDatabase(id);
        return ResponseEntity.ok().body("Usuario deletado!");
    }
}
