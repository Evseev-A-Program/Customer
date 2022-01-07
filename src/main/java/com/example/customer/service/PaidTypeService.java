package com.example.customer.service;

import com.example.customer.clients.OfferClients;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeLinkedToUserException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.EPaidType;
import com.example.customer.models.PaidType;
import com.example.customer.models.State;
import com.example.customer.repository.CustomerDao;
import com.example.customer.repository.PaidTypeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaidTypeService {

    private final PaidTypeDao paidTypeDao;
    private final CustomerService customerService;
    private final CustomerDao customerDao;

    public PaidType findPaidTypeById(Long id) throws PaidTypeNotFoundException {
        PaidType paidType = paidTypeDao.findById(id).get();
        if (paidType == null) {
            throw new PaidTypeNotFoundException("PaidType Not Found");
        }
        return paidType;
    }

    public List<String> getNameById(Set<Long> set) {

        List<String> list = new ArrayList<>();
            for (Long id : set) {
                list.add(paidTypeDao.findById(id)
                        .get()
                        .getName()
                        .name());
            }
            return list;
    }

    public Iterable<PaidType> findPaidTypeByIdCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomerById(id);
        return customer.getPaidTypes();
    }

    public Iterable<PaidType> findAllPaidTypes(){
        return  paidTypeDao.findAll();
    }

    public void deletePaidTypeById(Long id) throws PaidTypeNotFoundException, PaidTypeLinkedToUserException {
        PaidType paidType = findPaidTypeById(id);

//        if (!paidType.getCustomers().isEmpty()) {
//            throw new PaidTypeLinkedToUserException("PaidType is already linked to the user");
//        }
//
//        if (!OfferClients.checkPaidType(id)){
//            throw new PaidTypeLinkedToUserException("PaidType is already linked to the offer");
//        }

        paidType.setState(State.BANNED);
        paidTypeDao.save(paidType);
    }

    public void activePaidTypeById(Long id) throws PaidTypeNotFoundException, PaidTypeLinkedToUserException {
        PaidType paidType = findPaidTypeById(id);
        paidType.setState(State.ACTIVE);
        paidTypeDao.save(paidType);
    }

    public void savePaidType(String paidTypeStr, Long customerId) {

        EPaidType name = EPaidType.valueOf(paidTypeStr);
        PaidType paidType = paidTypeDao.findByName(name);
        Customer customer = customerDao.findById(customerId).get();

        customer.addPaidType(paidType);
        customerDao.save(customer);

    }




}
