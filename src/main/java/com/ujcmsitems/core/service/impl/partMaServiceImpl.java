package com.ujcmsitems.core.service.impl;


import com.ujcmsitems.core.domain.partMa;
import com.ujcmsitems.core.service.partMaService;
import com.ujcmsitems.utils.RespBean;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class partMaServiceImpl implements partMaService {

    @Override
    public RespBean addPartMa(String name, String picture, Data data) {
        return null;
    }

    @Override
    public RespBean deletePartMaById(int id) {
        return null;
    }

    @Override
    public partMa updatePartMa(int partMa) {
        return null;
    }

    @Override
    public partMa queryPartMaById(int id) {
        return null;
    }

    @Override
    public List<partMa> queryAllPartMa() {
        return null;
    }

    @Override
    public partMa queryPartByID(Integer id) {
        return null;
    }
}
