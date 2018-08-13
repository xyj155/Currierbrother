package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.Currier;
import com.example.currierbrother.mapper.CarMapper;
import com.example.currierbrother.mapper.CurrierMapper;
import com.example.currierbrother.service.CurrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrierServiceImpl implements CurrierService {

    @Autowired
    private CurrierMapper currierMapper;

    @Override
    public List<Currier> getCurrierList() {
        return currierMapper.getCurrierList();
    }
}
