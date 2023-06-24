package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.CountryStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleStatsDto;
import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;

public interface IplStatsService {

      List<String> getTeamNames();
      List<PlayerDto> getPlayersByTeam(String teamName);
      List<TeamStatsDto> getTeamStats();
      List<RoleStatsDto> getRoleStats();
      List<CountryStatsDto> getCountryStats();

}
