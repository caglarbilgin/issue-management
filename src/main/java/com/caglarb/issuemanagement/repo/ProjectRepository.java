package com.caglarb.issuemanagement.repo;

import com.caglarb.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndIdNotNull(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);


}
