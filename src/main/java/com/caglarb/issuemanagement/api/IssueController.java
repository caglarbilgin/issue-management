package com.caglarb.issuemanagement.api;


import com.caglarb.issuemanagement.dto.IssueDto;
import com.caglarb.issuemanagement.service.impl.IssueServiceImpl;
import com.caglarb.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //bu restful servisleri yayınlaybilmemiz için bu anotasyon gerekiyor
@RequestMapping(ApiPaths.IssueCtrl.CTRL) //bu projeyi yayınlamamız için bir path vermemiz gerekiyor
public class IssueController {
    //burada http methodlarımızı yayınlayacağımız servislerimizi yazıyoruz.

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) { // inject ettik
        this.issueServiceImpl = issueServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project) {

        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    //@RequestMapping(path = "", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
