package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ReplyVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.ReplyMapper;

@Service
public class ReplyService {
	@Autowired
	BoardMapper bMapper;
	
	@Autowired
	ReplyMapper rMapper;
	
	//reply Table에서는 댓글이 추가되고 board Table에서 댓글수도 증가되도록 함
	@Transactional
	public void insert(ReplyVO vo){
		rMapper.insert(vo);
		bMapper.updateReply(vo.getBno(), 1);
	}
	
	//reply Table에서 댓글도 삭제되고 board Table에서 댓글수도 차감되도록 함 
	@Transactional
	public void delete(int rno){
		ReplyVO vo=rMapper.read(rno);
		rMapper.delete(rno);
		bMapper.updateReply(vo.getBno(), -1);
	}
	
}
