package com.caglarb.issuemanagement.service;

import com.caglarb.issuemanagement.entity.Project;
import com.caglarb.issuemanagement.entity.User;
import com.caglarb.issuemanagement.repo.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete (Project project);


}
