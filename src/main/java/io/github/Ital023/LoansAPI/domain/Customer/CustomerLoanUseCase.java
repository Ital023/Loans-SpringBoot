package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerLoanUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerLoansDTO CustomerCases(CustomerEntity customer){
        List<LoansEntity> loans = new ArrayList<>();
        LoansEntity PERSONAL = new LoansEntity("PERSONAL",4);
        LoansEntity GUARANTEED = new LoansEntity("GUARANTEED",3);
        LoansEntity CONSIGNMENT = new LoansEntity("CONSIGNMENT",2);

        if(isEligibleForPersonalAndConsignmentLoans(customer)) {
            loans.add(PERSONAL);
            loans.add(CONSIGNMENT);
        }

        if(isEligibleForGuaranteedLoans(customer)){
            loans.add(GUARANTEED);
        }


        CustomerLoansDTO customerLoansDTO = new CustomerLoansDTO(customer.getName(), loans);

        return customerLoansDTO;
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
