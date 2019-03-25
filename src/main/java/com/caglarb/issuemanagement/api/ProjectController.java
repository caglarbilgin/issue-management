package com.caglarb.issuemanagement.api;

import com.caglarb.issuemanagement.dto.ProjectDto;
import com.caglarb.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //bu restful servisleri yayınlaybilmemiz için bu anotasyon gerekiyor
@RequestMapping("/project") //bu projeyi yayınlamamız için bir path vermemiz gerekiyor
public class ProjectController {
    //burada http methodlarımızı yayınlayacağımız servislerimizi yazıyoruz.

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) { // inject ettik
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){

        ProjectDto projectDto = projectServiceImpl.getById(id); //id si 1 olan Long değişenlerini dönmesi için 1L koyuyoruz.
        return ResponseEntity.ok(projectDto);
    }
}
