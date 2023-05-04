package com.example.service.iml;


import com.example.service.IService;

import javax.xml.ws.WebServiceRef;

@WebServiceRef
public class Service implements IService {
    @Override
    public float caculator(float number) {
        return number/23000;
    }
}
