package com.ujcmsitems.core.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author a1002
 */
@Data
public class NoticeDto {

    private String noticeTitle;

    private String noticeContent;

    private String firstTarget;

    private String htmlUrl;
}
