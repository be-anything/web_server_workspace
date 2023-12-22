package com.sh.mvc.board.model.entity;

import java.time.LocalDateTime;

public class BoardComment {
    private Long id;
    private Long boardId;
    private String memberId;
    private String content;
    // nullable한 컬럼이 만약 fk라면,
    // 기본형인 Long을 사용하면, db과 데이터 타입이 일치하지 않는다.
    private Long parentCommentId;
    private Integer commentLevel;

    private LocalDateTime regDate;

    @Override
    public String toString() {
        return "BoardComment{" +
                "id=" + id +
                ", boardId=" + boardId +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                ", commentLevel=" + commentLevel +
                ", parentCommentId=" + parentCommentId +
                ", regDate=" + regDate +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getContent() {
        return content;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public BoardComment() {
    }

    public BoardComment(Long id, Long boardId, String memberId, String content, Integer commentLevel, Long parentCommentId, LocalDateTime regDate) {
        this.id = id;
        this.boardId = boardId;
        this.memberId = memberId;
        this.content = content;
        this.commentLevel = commentLevel;
        this.parentCommentId = parentCommentId;
        this.regDate = regDate;
    }
}
