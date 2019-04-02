package com.caglarb.issuemanagement.api;

import com.caglarb.issuemanagement.dto.ProjectDto;
import com.caglarb.issuemanagement.service.impl.ProjectServiceImpl;
import com.caglarb.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //bu restful servisleri yayınlaybilmemiz için bu anotasyon gerekiyor
@RequestMapping(ApiPaths.ProjectCtrl.CTRL) //bu projeyi yayınlamamız için bir path vermemiz gerekiyor
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
//swagger ile yayınlayacağımız api dökümantasyonundaki isim başlığını belirliyoruz
public class ProjectController {
    //burada http methodlarımızı yayınlayacağımız servislerimizi yazıyoruz.

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) { // inject ettik
        this.projectServiceImpl = projectServiceImpl;
    }

    @ApiOperation(value = "Get By ID Operation", response = ProjectDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {

        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path = "", method = RequestMethod.PUT)
    @ApiOperation(value = "Update Operation", response = Boolean.class)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @ApiOperation(value = "Delete Operation", response = ProjectDto.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
