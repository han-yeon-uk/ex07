package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardTest {
    @Autowired
    private BoardMapper mapper;
    //목록출력
    @Test
    public void list() { mapper.list(); }
    //게시글 추가
    @Test
    public void insert() {
    	BoardVO vo=new BoardVO();
    	vo.setTitle("게시글 추가합니다.");
    	vo.setContent("내용을 추가합니다.");
    	vo.setWriter("user09");
    	mapper.insert(vo); 
    }
    //게시글 읽기
    @Test
    public void read() { mapper.read(5); }
    //게시글 수정
    @Test
    public void update() {
    	BoardVO vo=new BoardVO();
    	vo.setTitle("게시글을 수정합니다..");
    	vo.setContent("내용을 수정합니다..");
    	vo.setWriter("user08");
    	vo.setBno(3);
    	mapper.update(vo); 
    }
    //게시글 삭제
    @Test
    public void delete() { mapper.delete(2); }
}
