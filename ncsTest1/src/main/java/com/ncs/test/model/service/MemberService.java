package com.ncs.test.model.service;

import com.ncs.test.model.dao.MemberDao;
import com.ncs.test.model.vo.Member;
import org.apache.ibatis.session.SqlSession;

import static com.ncs.test.common.SqlSessionTemplate.getSqlSession;

public class MemberService {
    private MemberDao memberDao = new MemberDao();
    public Member loginMember(String memberId) {
        SqlSession session = getSqlSession();
        Member member = memberDao.loginMember(session, memberId);
        session.close();
        return member;
    }
}
