package io.github.Ital023.LoansAPI.domain.Customer;

import io.github.Ital023.LoansAPI.loans.LoansEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerLoanUseCase {

    public CustomerLoansDTO CustomerCases(CustomerEntity customer){
        List<LoansEntity> loans = new ArrayList<>();
        LoansEntity PERSONAL = new LoansEntity("PERSONAL",4);
        LoansEntity GUARANTEED = new LoansEntity("GUARANTEED",3);
        LoansEntity CONSIGNMENT = new LoansEntity("CONSIGNMENT",2);

        if(customer.getIncome() <= 3000 ||( (customer.getIncome() >= 3000 && customer.getIncome() <= 5000) && customer.getAge() < 30 && customer.getLocation().equals("SP")) )
        {
            loans.add(PERSONAL);
            loans.add(CONSIGNMENT);
        }

        if(customer.getIncome() >= 5000){
            loans.add(GUARANTEED);
        }


        CustomerLoansDTO customerLoansDTO = new CustomerLoansDTO(customer.getName(), loans);

        return customerLoansDTO;
    }



}
