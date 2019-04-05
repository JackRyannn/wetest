package com.renchao.wetest.services;

import com.renchao.wetest.daos.MobileDao;
import com.renchao.wetest.models.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {
    @Autowired
    MobileDao mobileDao;

    public Mobile getMobileById(String id) {
        return mobileDao.select(id);
    }

    public List<Mobile> getMobiles() {
        return mobileDao.selectAll();
    }

    public List<String> getDistinctKinds(String colName) {
        return mobileDao.selectDistinctKinds(colName);
    }

    public List<Mobile> getMobilesByCondition(String brand,String system,String size) {
        return mobileDao.selectByCondition(brand,system,size);
    }
}