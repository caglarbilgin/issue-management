package com.caglarb.issuemanagement.service;

import com.caglarb.issuemanagement.dto.IssueDto;
import com.caglarb.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable (Pageable pageable);

    Boolean delete (Long issue);


    IssueDto update(Long id, IssueDto project);
}
