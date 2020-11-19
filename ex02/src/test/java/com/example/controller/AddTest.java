package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AddVO;
import com.example.mapper.AddMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class AddTest {
    @Autowired
    private AddMapper mapper;
    
    @Test
    public void list() { mapper.list(); }
    
    @Test
    public void insert() {
    	AddVO vo=new AddVO();
    	vo.setName("고라니");
    	vo.setTel("010-7878-7878");
    	vo.setAddr("김포");
    	mapper.insert(vo);
    }
    
    @Test
    public void read() { mapper.read(3); }
  
    @Test
    public void 고라니() {
    	AddVO vo=new AddVO();
    	vo.setName("고라니");
    	vo.setTel("010-7878-7878");
    	vo.setAddr("김포");
    	vo.setAno(6);
    	mapper.update(vo);
    }
    @Test
    public void delete() { mapper.delete(7); }
    
}
