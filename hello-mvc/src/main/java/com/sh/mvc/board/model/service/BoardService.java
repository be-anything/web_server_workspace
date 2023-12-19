package com.sh.mvc.board.model.service;

import com.sh.mvc.board.model.dao.BoardDao;
import com.sh.mvc.board.model.entity.Attachment;
import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.vo.BoardVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.sh.mvc.common.SqlSessionTemplate.getSqlSession;

public class BoardService {
    private BoardDao boardDao = new BoardDao();

    public List<Board> findAll() {
        SqlSession session = getSqlSession();
        List<Board> boards = boardDao.findAll(session);
        session.close();
        return boards;
    }

    public List<BoardVo> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<BoardVo> boards = boardDao.findAll(session, param);
        session.close();
        return boards;
    }

    public int getTotalCount() {
        SqlSession session = getSqlSession();
        int totalCount = boardDao.getTotalCount(session);
        session.close();
        return totalCount;
    }

    public BoardVo findById(long id) {
        SqlSession session = getSqlSession();
        BoardVo board = boardDao.findById(session, id);
        session.close();
        return board;
    }

    public int insertBoard(BoardVo board) {
        SqlSession session = getSqlSession();
        int result = 0;
        try {
            // board 테이블에 등록
            result = boardDao.insertBoard(session, board);
            System.out.println("BoardService#insertBoard : board#id" + board.getId());
            // attachment 테이블에 등록
            List<Attachment> attachments = board.getAttachments();
            if(!attachments.isEmpty()){
                for (Attachment attach: attachments) {
                    attach.setBoardId(board.getId());
                    result = boardDao.insertAttachment(session, attach);
                }
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;

    }

    public int updateBoard(Board board) {
        SqlSession session = getSqlSession();
        int result = 0;
        try {
            result = boardDao.updateBoard(session, board);
            session.commit();
        } catch (Exception e){
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteBoard(long id) {
        SqlSession session = getSqlSession();
        int result = 0;
        try {
            result = boardDao.deleteBoard(session, id);
            session.commit();
        } catch (Exception e){
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
