package com.tabledata.bootcamp.web.model;


import com.tabeldata.bootcamp.web.model.Example;
import com.tabledata.bootcamp.web.Dao.KategoriDao;
import lombok.Data;

@Data
public class Kategori {
    private  Integer category_id;
    private  Integer department_id;
    private  String name;
    private  String description;
}
