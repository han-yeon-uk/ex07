package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardTest {
    @Autowired
    private BoardMapper mapper;
    //������
    @Test
    public void list() { mapper.list(); }
    //�Խñ� �߰�
    @Test
    public void insert() {
    	BoardVO vo=new BoardVO();
    	vo.setTitle("�Խñ� �߰��մϴ�.");
    	vo.setContent("������ �߰��մϴ�.");
    	vo.setWriter("user09");
    	mapper.insert(vo); 
    }
    //�Խñ� �б�
    @Test
    public void read() { mapper.read(5); }
    //�Խñ� ����
    @Test
    public void update() {
    	BoardVO vo=new BoardVO();
    	vo.setTitle("�Խñ��� �����մϴ�..");
    	vo.setContent("������ �����մϴ�..");
    	vo.setWriter("user08");
    	vo.setBno(3);
    	mapper.update(vo); 
    }
    //�Խñ� ����
    @Test
    public void delete() { mapper.delete(2); }
}
