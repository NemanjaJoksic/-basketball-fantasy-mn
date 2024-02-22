package org.joksin.bf.gameengine.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "team")
public class TeamEntity {

  @Id private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  private CountryEntity country;
}
