package com.tabledata.bootcamp.web.Dao;

import com.tabledata.bootcamp.web.model.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class  KategoriDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private LocalDateTime jdbcTemplate;

    public List<Kategori> list(){
        String sql = "select * from Kategori";
        return this.jdbcTemplate.query(sql, new KategoriDao.RowMapperInner());
    }

    public Kategori findById(Integer category_id) {
        String sql = "select * from example where id = :kode";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("kode", category_id);
        return this.jdbcTemplate.queryForObject(sql, map, new KategoriDao.RowMapperInner());
    }
    public void insert(Kategori data) {
        String sql = "insert into example(id, nama, last_update, last_date, salary, description, is_active) values (:kode, :nama, :last_update, :last_date, :salary, :descrition, :active)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("kode", data.getCategory_id());
        map.addValue("id", data.getDepartment_id());
        map.addValue("name", data.getName());
        map.addValue("deskripsi", data.getDescription();
        this.jdbcTemplate.update(sql, map);
    }
    public void update(Kategori data) {
        String sql = "update kategori set nama = :nama, deskripsi = :deskripsi where id = :kode";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("kode", data.getCategory_id());
        map.addValue("id", data.getDepartment_id());
        map.addValue("nama", data.getName());
        map.addValue("deskripsi", data.getDescription();
        this.jdbcTemplate.update (sql, map);
    }

    public void delete(Integer id) {
        String sql = "delete from kategori where id = :kode";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("kode", id);
        this.jdbcTemplate.update(sql, map);
    }

    public class RowMapperInner implements RowMapper<Kategori> {

        @Override
        public Kategori mapRow(ResultSet rs, int rowNum) throws SQLException {
            Kategori data = new Kategori();
            data.setCategory_id(rs.getInt("id"));
            data.setDescription(rs.getString("description"));
            data.setName(rs.getString("nama"));
            return data;
        }
    }


