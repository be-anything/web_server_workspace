package com.ncs.test.controller;

import com.ncs.test.model.service.MemberService;
import com.ncs.test.model.vo.Member;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class MemberController extends HttpServlet {
    private MemberService memberService = new MemberService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값 처리
        String memberId = req.getParameter("memberId");
        String memberPwd = req.getParameter("memberPwd");

        // 2. DB에서 아이디로 찾아오기
        Member member = memberService.loginMember(memberId);
        System.out.println(member);

        if(member != null && memberPwd.equals(member.getMemberPwd())){
            req.getSession().setAttribute("loginMember", member);
        }
        else {
            req.getSession().setAttribute("msg", "로그인 실패");
        }
        // 3. 리다이렉트
        resp.sendRedirect(req.getContextPath() + "/");
    }
}