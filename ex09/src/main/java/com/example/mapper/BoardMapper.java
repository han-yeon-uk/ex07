package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> list(Criteria cri);
	public int totalCount();
	public void addAttach(String fileName);
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public List<String> getAttach(int bno);
	public void deleteAttach(int bno);
	public void replaceAttach(@Param("fileName")String fileName,@Param("bno")int bno);
	public void update(BoardVO vo);
}
