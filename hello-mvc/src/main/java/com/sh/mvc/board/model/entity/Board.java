package com.sh.mvc.board.model.entity;

import java.time.LocalDateTime;

/**
 * entity 클래스
 * - db 테이블과 매칭되는 클래스
 *
 */
public class Board {
    private long id;
    private String title;
    private String memberId;
    private String content;
    private int readCount;
    private LocalDateTime regDate;

    public Board() {}

    public Board(long id, String title, String memberId, String content, int readCount, LocalDateTime regDate) {
        this.id = id;
        this.title = title;
        this.memberId = memberId;
        this.content = content;
        this.readCount = readCount;
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                ", readCount=" + readCount +
                ", regDate=" + regDate +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getContent() {
        return content;
    }

    public int getReadCount() {
        return readCount;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setValue(String name, String value) {
        switch (name) {
            case "title" : this.title = value; break;
            case "memberId" : this.memberId = value; break;
            case "content" : this.content = value; break;
            default: throw new RuntimeException("부적절한 name값 : " + name);
        }
    }
}
