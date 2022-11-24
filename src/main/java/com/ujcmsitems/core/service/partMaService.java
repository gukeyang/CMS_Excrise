package com.ujcmsitems.core.service;

import com.ujcmsitems.core.domain.partMa;
import com.ujcmsitems.utils.R;
import com.ujcmsitems.utils.RespBean;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


public interface partMaService {


    R addPartMa(String name, String picture, Date date);

    R  deletePartMaById(int id);

    partMa updatePartMa(int partMa);

    partMa queryPartMaById(int id);

    List<partMa> queryAllPartMa();

    partMa queryPartByID(Integer id);

}
