package com.main.Service;

import com.main.Entity.MainEntity;
import com.main.Entity.IMainRepository;

public class MainService implements IMainService {
    private final IMainRepository customerRepository;

    public MainService(IMainRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    private static IMainService customerService;

    public static IMainService getInstance(IMainRepository iMainRepository) {
        if (customerService == null)
            customerService = new MainService(iMainRepository);
        return customerService;
    }

    @Override
    public MainEntityDuplicate findByID(int id) {
        MainEntity mainEntity = customerRepository.findById(id);
        if (mainEntity != null) {
            return new MainEntityDuplicate(mainEntity.getFio(), mainEntity.getCode(), mainEntity.getLimit());
        }
        return null;
    }
}
