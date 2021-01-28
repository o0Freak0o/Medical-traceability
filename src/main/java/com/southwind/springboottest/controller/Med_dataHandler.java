package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.Med_data;
import com.southwind.springboottest.repository.Med_dataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class Med_dataHandler {
    @Autowired
    private Med_dataRepository Rep1;
    @GetMapping("/findAll")
    public List<Med_data> findAll(){
        return Rep1.findAll();
    }
    @GetMapping("/findAll/{page}/{size}")
    public Page<Med_data> findAll(@PathVariable("page") Integer page, @PathVariable("size")
            Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return Rep1.findAll(pageable);
    }
    @PostMapping("/save")
    public String save(@RequestBody Med_data dt){
        Med_data res = Rep1.save(dt);
        if(res != null){
            return "success!";
        }else {
            return "error!";
        }
    }
    @GetMapping("/findById/{id}")
    public Med_data findById(@PathVariable("id") Integer id){
        return Rep1.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Med_data dt){
        Med_data res = Rep1.save(dt);
        if(res != null){
            return "success!";
        }else {
            return "error!";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        Rep1.deleteById(id);
    }

}
