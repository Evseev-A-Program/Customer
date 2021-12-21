package utils;

import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.security.core.Authentication;

public class CustomerFromAuthentication {
    public static CustomerDTO getCustomer(Authentication authentication){
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        return CustomerDTO.from(details.getCustomer());
    }
}
