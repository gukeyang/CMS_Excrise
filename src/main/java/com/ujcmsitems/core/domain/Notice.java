package com.ujcmsitems.core.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author a1002
 * 中心要闻/公告通知表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notice")
@EntityListeners(AuditingEntityListener.class)
public class Notice implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type= IdType.AUTO)
    private Integer id;
    @Column(name = "notice_title")
    private String noticeTitle;
    @Column(name = "notice_content")
    private String noticeContent;
    @Column(name = "notice_time")
    private String noticeTime;
    @Column(name = "status")
    //附件
    private String status;
    @Column(name = "first_target")
    private String firstTarget;
    @Column(name = "html_url")
    private String htmlUrl;

    public Notice(String noticeTitle, String noticeContent, String noticeTime, String status, String firstTarget) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
        this.status = status;
        this.firstTarget = firstTarget;
    }

    public Notice(String noticeTitle, String noticeContent, String noticeTime, String firstTarget) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
        this.firstTarget = firstTarget;
    }

    public Notice(String noticeTitle, String noticeContent, String format, String status, String firstTarget, String htmlUrl) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
        this.status = status;
        this.firstTarget = firstTarget;
        this.htmlUrl=htmlUrl;
    }
}
