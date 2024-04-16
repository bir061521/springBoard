package com.fastcampus.ch2.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class CommentDto {
    private Integer cno;    //pk
    private Integer bno;    //fk_board
    private String id;      //fk_user

    private Integer parent_cno; //pk의 파생속성
    private String content;
    private LocalDateTime regDate;

    public CommentDto() {
    }

    public CommentDto(Integer cno, Integer bno, String id, Integer parent_cno, String content, LocalDateTime regDate) {
        this.cno = cno;
        this.bno = bno;
        this.id = id;
        this.parent_cno = parent_cno;
        this.content = content;
        this.regDate = regDate;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getBno(Integer bno) {
        return bno;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getParent_cno() {
        return parent_cno;
    }

    public void setParent_cno(Integer parent_cno) {
        this.parent_cno = parent_cno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "cno=" + cno +
                ", bno=" + bno +
                ", id='" + id + '\'' +
                ", parent_cno=" + parent_cno +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
