package com.caglarb.issuemanagement.service.impl;

import com.caglarb.issuemanagement.dto.IssueDto;
import com.caglarb.issuemanagement.entity.Issue;
import com.caglarb.issuemanagement.repo.IssueRepository;
import com.caglarb.issuemanagement.service.IssueService;
import com.caglarb.issuemanagement.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {


    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) { // burada issueRepository'i inject ediyoruz

        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date can not be null !!");
        }

        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public Tpage<IssueDto> getAllPageable(Pageable pageable) {
        Tpage page = new Tpage<IssueDto>();
        Page<Issue> data = issueRepository.findAll(pageable);
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;

    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
