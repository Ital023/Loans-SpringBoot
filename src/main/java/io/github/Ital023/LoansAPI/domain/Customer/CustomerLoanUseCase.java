package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import io.github.Ital023.LoansAPI.loans.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerLoanUseCase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoansRepository loansRepository;

    public CustomerLoansDTO CustomerCases(CustomerEntity customer){
        List<LoansEntity> loansCustomer = new ArrayList<>();

        if(isEligibleForPersonalAndConsignmentLoans(customer)) {
            loansCustomer.add(loansRepository.findByType("PERSONAL"));
            loansCustomer.add(loansRepository.findByType("CONSIGNMENT"));
        }

        if(isEligibleForGuaranteedLoans(customer)){
            loansCustomer.add(loansRepository.findByType("GUARANTEED"));
        }


        CustomerLoansDTO customerLoansDTO = new CustomerLoansDTO(customer.getName(), loansCustomer);

        return customerLoansDTO;
    }

    public CustomerLoansDTO getCustomer(UUID id){
        Optional<CustomerEntity> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()){
            CustomerEntity customer = customerOptional.get();
            return CustomerCases(customer);
        }

        return null;
    }

    public void saveDatabase(CustomerEntity customer){
        customerRepository.save(customer);
    }

    private boolean isEligibleForPersonalAndConsignmentLoans(CustomerEntity customer) {
        return (customer.getIncome() <= 3000 ||( (customer.getIncome() >= 3000 && customer.getIncome() <= 5000) && customer.getAge() < 30 && customer.getLocation().equals("SP")));
    }

    private boolean isEligibleForGuaranteedLoans(CustomerEntity customer){
        return customer.getIncome() >= 5000;
    }

}
