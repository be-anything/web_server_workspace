package com.sh.menu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menuOrder.do")
public class MenuOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 사용자 입력값
        String mainMenu = req.getParameter("mainMenu");
        String sideMenu = req.getParameter("sideMenu");
        String drinkMenu = req.getParameter("drinkMenu");

        // 가격 계산하기
        int totalPrice = 0;
        switch (mainMenu) {
            case "한우버거" : totalPrice += 5000; break;
            case "밥버거" : totalPrice += 4500; break;
            case "치즈버거" : totalPrice += 4000; break;
        }
        switch (sideMenu) {
            case "감자튀김" : totalPrice += 1500; break;
            case "어니언링" : totalPrice += 1700; break;
        }
        switch (drinkMenu) {
            case "콜라" : ;
            case "사이다" : totalPrice += 1000; break;
            case "커피" : totalPrice += 1500; break;
            case "밀크쉐이크" : totalPrice += 2500; break;
        }

        // java에서 생성한 데이터를 jsp로 전달하기위해서, req객체에 setAttribute에 저장
        req.setAttribute("totalPrice", Integer.toString(totalPrice));

        // view단으로 forwarding jsp 경로 지정
        RequestDispatcher reqDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/menuEnd.jsp");
        reqDispatcher.forward(req, resp);
    }
}
