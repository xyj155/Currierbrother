package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.Express;
import com.example.currierbrother.mapper.ExpressMapper;
import com.example.currierbrother.service.ExpressStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressStationServiceImpl implements ExpressStationService {
    @Autowired
    private ExpressMapper mapper;

    @Override
    public List<Express> getExpressAllList() {
        return mapper.getAllStation();
    }
}
