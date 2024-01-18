package com.yedam.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	MemberVO selectMember(@Param("userId") String userId, @Param("userPw") String userPw);
	List<MemberVO> selectList();
	MemberVO selectOne(String mid);
	
	// 입력, 삭제
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
	
	
}