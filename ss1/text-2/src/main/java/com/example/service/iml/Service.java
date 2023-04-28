package com.example.service.iml;

import com.example.repository.IRepository;
import com.example.repository.iml.Repository;
import com.example.service.IService;

public class Service implements IService {
   private IRepository repository = new Repository();
    @Override
    public String check(String englishCheck) {
        return repository.check(englishCheck) ;
    }
}
