package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI {

	@Override
	public MemberVo getMember(String userId) {

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		// 사용자의 정보
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);

		// 사용후 닫아준다
		sqlSession.close();

		return memberVo;
	}

}
