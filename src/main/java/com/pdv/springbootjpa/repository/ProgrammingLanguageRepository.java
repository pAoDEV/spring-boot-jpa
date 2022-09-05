package com.pdv.springbootjpa.repository;

import com.pdv.springbootjpa.entity.ProgrammingLanguage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {

    @Query("SELECT t FROM ProgrammingLanguage t WHERE upper(t.keyword) = LOWER(:keyword)")
    List<ProgrammingLanguage> findByKeyword(@Param("keyword") String keyword, Sort sort);
}
