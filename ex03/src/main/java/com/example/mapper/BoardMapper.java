package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
    public List<BoardVO> list(Criteria cri); //목록출력 메서드
    public BoardVO read(int bno); //단일 선택출력 메서드
    public void insert(BoardVO vo); //목록추가 메서드
    public void update(BoardVO vo); //목록수정 메서드
    public void delete(int bno); //단일 선택목록 삭제 메서드
    public int totalCount(Criteria cri); //토탈 데이터 갯수 메서드
}
