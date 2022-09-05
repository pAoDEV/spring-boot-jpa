package com.pdv.springbootjpa.controller;

import com.pdv.springbootjpa.entity.ProgrammingLanguage;
import com.pdv.springbootjpa.model.response.ResponseModel;
import com.pdv.springbootjpa.repository.ProgrammingLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pdv.springbootjpa.util.ResponseUtil.createResponseModel;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/programming-language")
public class ProgrammingLanguageController {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @GetMapping
    public ResponseEntity<ResponseModel<?>> findProgrammingLanguage(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        if (Strings.isBlank(keyword)) {
            return ResponseEntity.ok(createResponseModel(programmingLanguageRepository.findAll(Sort.by(sortDirection, sort.toLowerCase()))));
        } else {
            return ResponseEntity.ok(createResponseModel(programmingLanguageRepository.findByKeyword(keyword, Sort.by(sortDirection, sort.toLowerCase()))));
        }
    }

    @PostMapping
    public ResponseEntity<ResponseModel<?>> addProgrammingLanguage(
            @RequestBody
            List<ProgrammingLanguage> programmingLanguages
    ) {
        return ResponseEntity.ok(createResponseModel(programmingLanguageRepository.saveAll(programmingLanguages)));
    }

    @DeleteMapping
    public ResponseEntity<ResponseModel<?>> truncateProgrammingLanguage() {
        programmingLanguageRepository.deleteAll();
        return ResponseEntity.ok(createResponseModel(1000));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel<?>> deleteProgrammingLanguage(
            @PathVariable("id") long id
    ) {
        programmingLanguageRepository.deleteById(id);
        return ResponseEntity.ok(createResponseModel(1000));
    }
}
