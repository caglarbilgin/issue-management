package com.caglarb.issuemanagement.service;

import com.caglarb.issuemanagement.dto.IssueDto;
import com.caglarb.issuemanagement.entity.Issue;
import com.caglarb.issuemanagement.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    Tpage<IssueDto> getAllPageable (Pageable pageable);

    Boolean delete (IssueDto issue);



}
