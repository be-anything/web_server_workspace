package com.sh.mvc.board.controller;

import com.sh.mvc.board.model.entity.Attachment;
import com.sh.mvc.board.model.service.BoardService;
import com.sh.mvc.board.model.vo.BoardVo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
    private BoardService boardService = new BoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값 처리
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        // 2. 업무로직
        BoardVo board = boardService.findById(id);
        System.out.println(board);
        req.setAttribute("board", board);
        // 3. forwarding
        req.getRequestDispatcher("/WEB-INF/views/board/boardUpdate.jsp").forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 0. 셋팅
        // DiskFileItemFactory - ServletFileUpload
        File repository = new File("C:\\Users\\user1\\Dropbox\\Workspaces\\web_server_workspace\\hello-mvc\\src\\main\\webapp\\upload\\board");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(repository);
        factory.setSizeThreshold(10 * 1024 * 1024);
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        BoardVo board = new BoardVo();

        try {
            // 1. 사용자 입력값 처리 및 파일 업로드
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for(FileItem item : fileItems) {
                String name = item.getFieldName();
                if(item.isFormField()){
                    // form 내의 일반 field
                    String value = item.getString("utf-8");
                    board.setValue(name, value);
                }
                else {
                    // form 내의 file
                    // 서버 컴퓨터에 저장하기
                    if(item.getSize() > 0){
                        // 기존 이름과 uuid로 발급된 새로운 이름 저장하기
                        String originalFilename = item.getName();
                        int dotIndex = originalFilename.lastIndexOf(".");
                        String ext = dotIndex > -1 ? originalFilename.substring(dotIndex) : "";

                        UUID uuid = UUID.randomUUID();
                        String renamedFilename = uuid + ext;

                        // 서버 컴퓨터에 저장하기
                        File upFile = new File(repository, renamedFilename);
                        item.write(upFile); // 파일 출력

                        // Attachment 객체 생성
                        Attachment attach = new Attachment();
                        attach.setOriginalFilename(originalFilename);
                        attach.setRenamedFilename(renamedFilename);
                        board.addAttachment(attach);
                    }
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println(board);

        // 2. 업무 로직
        int result = boardService.updateBoard(board);
        req.setAttribute("board", board);
        if(result > 0) {
            req.getSession().setAttribute("msg", "게시글 수정이 완료되었습니다. 😀");
        }
        else {
            req.getSession().setAttribute("msg", "게시글 수정에 실패했습니다. 😀");
        }
        // 3. redirect
        resp.sendRedirect(req.getContextPath() + "/board/boardList?id" + board.getId());
    }
}