package com.sh.mvc.photo.model.entity;

import java.time.LocalDateTime;

public class Photo {
    private Long id;
    private String memberId;
    private String content;
    private String originalFilename;
    private String renamedFilename;
    private int readCount;
    private LocalDateTime regDate;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                ", originalFilename='" + originalFilename + '\'' +
                ", renamedFilename='" + renamedFilename + '\'' +
                ", readCount=" + readCount +
                ", regDate=" + regDate +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public void setRenamedFilename(String renamedFilename) {
        this.renamedFilename = renamedFilename;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getContent() {
        return content;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public String getRenamedFilename() {
        return renamedFilename;
    }

    public int getReadCount() {
        return readCount;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public Photo(Long id, String memberId, String content, String originalFilename, String renamedFilename, int readCount, LocalDateTime regDate) {
        this.id = id;
        this.memberId = memberId;
        this.content = content;
        this.originalFilename = originalFilename;
        this.renamedFilename = renamedFilename;
        this.readCount = readCount;
        this.regDate = regDate;
    }

    public Photo() {
    }
}
