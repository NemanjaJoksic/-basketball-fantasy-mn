package org.joksin.bf.gameengine.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "country")
public class CountryEntity {
  @Id private Long id;

  private String name;

  private String code;
}
