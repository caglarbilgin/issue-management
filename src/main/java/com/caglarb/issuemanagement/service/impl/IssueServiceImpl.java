package com.caglarb.issuemanagement.service.impl;

import com.caglarb.issuemanagement.dto.IssueDto;
import com.caglarb.issuemanagement.repo.IssueRepository;
import com.caglarb.issuemanagement.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {


    private final IssueRepository issueRepository;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository) { // burada issueRepository'i inject ediyoruz

        this.issueRepository = issueRepository;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date can not be null !!");
        }
        return null;
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
