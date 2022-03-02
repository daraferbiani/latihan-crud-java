package com.tabledata.bootcamp.web.controller;

import com.tabeldata.bootcamp.web.dao.ExampleDao;
import com.tabeldata.bootcamp.web.model.Example;
import com.tabledata.bootcamp.web.Dao.KategoriDao;
import com.tabledata.bootcamp.web.model.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KategoriController {

    @Autowired
    private KategoriDao dao;

    @GetMapping("/list")
    public List<Example> list() {
        return dao.list();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            Example data = this.dao.findById(id);
            return ResponseEntity.ok(data);
        } catch (EmptyResultDataAccessException erdae) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/show")
    public Kategori showData(
            @RequestParam(name = "msg", required = true) String message,
            @RequestParam(name = "oth", required = false) String other,
            BigDecimal salary,
            Boolean active) {
        Kategori data = new Kategori();
        data.setCategory_id (category_id);
        data.setDepartment_id(Department_id);
        data.setName(nama);
        data.setDescription(deskripsi);
        return data;
    }

    @PostMapping(value = "/input")
    public ResponseEntity<?> inputData(@RequestBody @Valid Kategori   data) {
        try {
            this.dao.insert(data);
            return ResponseEntity.ok().build();
        } catch (DuplicateKeyException dke) {
            dke.printStackTrace();
            return ResponseEntity.badRequest()
                    .body("Duplicate data");
        } catch (DataAccessException dea) {
            dea.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("database gak konek atau sql salah");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("Gak tau errornya apa! check sendiri");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        this.dao.delete(id);
        return ResponseEntity.ok().build();
    }

}
