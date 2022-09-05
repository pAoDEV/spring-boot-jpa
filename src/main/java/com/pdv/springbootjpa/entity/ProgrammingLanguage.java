package com.pdv.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "programming_language")
public class ProgrammingLanguage {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    @NotEmpty
    private String language;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String keyword;
}
