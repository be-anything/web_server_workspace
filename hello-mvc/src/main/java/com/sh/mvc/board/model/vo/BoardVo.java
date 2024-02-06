package com.sh.mvc.board.model.vo;

import com.sh.mvc.board.model.entity.Attachment;
import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.entity.BoardComment;
import com.sh.mvc.member.model.entity.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * vo클래스 value object
 * - immutable한 value 객체
 * - entity클래스를 확장한 객체
 */
public class BoardVo extends Board {
    private Member member;
    private int attachCount; // 첨부파일 개수

    private int commentCount; // 코멘트 개수
    private List<Attachment> attachments = new ArrayList<>();
    // 삭제 가능한 첨부파일 목록 필드
    private List<Long> delFiles = new ArrayList<>();
    private List<BoardComment> comments;

    public void setComments(List<BoardComment> comments) {
        this.comments = comments;
    }

    public List<BoardComment> getComments() {
        return comments;
    }

    public void setDelFiles(List<Long> delFiles) {
        this.delFiles = delFiles;
    }

    public List<Long> getDelFiles() {
        return delFiles;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void
    setValue(String name, String value) {
        switch (name) {
            case "id" : this.setId(Long.parseLong(value)); break;
            case "title" : this.setTitle(value); break;
            case "memberId" : this.setMemberId(value); break;
            case "content" : this.setContent(value); break;
            case "delFile" : this.delFiles.add(Long.parseLong(value)); break;
            default: throw new RuntimeException("부적절한 name값 : " + name);
        }
    }

    public void setAttachCount(int attachCount) {
        this.attachCount = attachCount;
    }

    public int getAttachCount() {
        return attachCount;
    }
    public void addAttachment(Attachment attachment){
        this.attachments.add(attachment);
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "member=" + member +
                ", attachCount=" + attachCount +
                ", commentCount=" + commentCount +
                ", attachments=" + attachments +
                ", delFiles=" + delFiles +
                ", comments=" + comments +
                '}';
    }
}
