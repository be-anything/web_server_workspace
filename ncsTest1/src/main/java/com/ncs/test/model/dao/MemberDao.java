package com.ncs.test.model.dao;

import com.ncs.test.model.vo.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {
    public Member loginMember(SqlSession session, String memberId) {
        return session.selectOne("member.loginMember", memberId);
    }
}
