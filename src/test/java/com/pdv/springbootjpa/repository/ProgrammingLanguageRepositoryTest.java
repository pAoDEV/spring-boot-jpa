package com.pdv.springbootjpa.repository;

import com.pdv.springbootjpa.config.DatasourceConfiguration;
import com.pdv.springbootjpa.entity.ProgrammingLanguage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@DataJpaTest
@ExtendWith({SpringExtension.class})
@Import(DatasourceConfiguration.class)
/*@ImportAutoConfiguration(DatasourceConfiguration.class)*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProgrammingLanguageRepositoryTest {

    @Autowired
    private ProgrammingLanguageRepository repository;

    @Order(0)
    @Test
    public void saveProgrammingLanguage() {
        ProgrammingLanguage data = ProgrammingLanguage.builder()
                .language("java")
                .keyword("JAVA")
                .build();
        repository.save(data);
        Assertions.assertNotNull(data.getId());
    }

    @Order(1)
    @Test
    void saveProgrammingLanguage_Multiple() {
        List<ProgrammingLanguage> bulkData = Arrays.asList(
                ProgrammingLanguage.builder().language("java").keyword("JAVA").build(),
                ProgrammingLanguage.builder().language("golang").keyword("GOLANG").build()
        );
        repository.saveAll(bulkData);
        bulkData.stream().map(ProgrammingLanguage::getId).forEach(Assertions::assertNotNull);
    }

    @Order(2)
    @Test
    void findProgrammingLanguageByKeyword() {
        List<ProgrammingLanguage> res = repository.findByKeyword("java", any());
        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals("Java", res.get(0).getLanguage());
        Assertions.assertEquals("JAVA", res.get(0).getKeyword());
    }
}
