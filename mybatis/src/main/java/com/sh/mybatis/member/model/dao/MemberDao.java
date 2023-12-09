package com.sh.mybatis.member.model.dao;

import com.sh.mybatis.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {
    public Member findById(SqlSession session, String id){
        return session.selectOne("member.findById", id);
    }
}
