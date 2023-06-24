package com.careerit.iplstats.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamStatsDto {
  private String teamName;
  private double totalAmount;
}
