package com.caglarb.issuemanagement.dto;

import com.caglarb.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {

    private Long id;
    private String description;
    private Date date;
    private String details;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;

}
