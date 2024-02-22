package org.joksin.bf.gameengine.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joksin.bf.gameengine.model.enums.PlayerPosition;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "player")
public class PlayerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer number;

  private Double height;

  @Enumerated(EnumType.STRING)
  private PlayerPosition position;

  private Date born;

  @ManyToOne(fetch = FetchType.LAZY)
  private CountryEntity country;

  @ManyToOne(fetch = FetchType.LAZY)
  private TeamEntity team;
}
