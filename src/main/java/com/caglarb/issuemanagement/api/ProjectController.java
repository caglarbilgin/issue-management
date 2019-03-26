package com.caglarb.issuemanagement.api;

import com.caglarb.issuemanagement.dto.ProjectDto;
import com.caglarb.issuemanagement.service.impl.ProjectServiceImpl;
import com.caglarb.issuemanagement.util.ApiPaths;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //bu restful servisleri yayınlaybilmemiz için bu anotasyon gerekiyor
@RequestMapping(ApiPaths.ProjectCtrl.CTRL) //bu projeyi yayınlamamız için bir path vermemiz gerekiyor
public class ProjectController {
    //burada http methodlarımızı yayınlayacağımız servislerimizi yazıyoruz.

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) { // inject ettik
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {

        ProjectDto projectDto = projectServiceImpl.getById(id); //id si 1 olan Long değişenlerini dönmesi için 1L koyuyoruz.
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {

        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path = "", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
