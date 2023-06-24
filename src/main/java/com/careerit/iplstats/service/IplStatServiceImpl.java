package com.careerit.iplstats.service;

import com.careerit.iplstats.dao.IplStatsRepo;
import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.CountryStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleStatsDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IplStatServiceImpl implements IplStatsService{

  private final IplStatsRepo iplStatsRepo;
  private final ObjectMapper objectMapper;

  @Override
  public List<String> getTeamNames() {
    List<String> teamNames = iplStatsRepo.findTeamNames();
    log.info("Total teams count is : {}", teamNames.size());
    return teamNames;
  }

  @Override
  public List<PlayerDto> getPlayersByTeam(String teamName) {
    Assert.notNull(teamName,"Team name should not be null");
    log.info("Team name is : {}", teamName);
    List<Player> players = iplStatsRepo.findByTeam(teamName);
    List<PlayerDto> playerDtos = players.stream().map(player -> objectMapper.convertValue(player, PlayerDto.class)).toList();
    log.info("Total players found for team {} is : {}", teamName, playerDtos.size());
    return playerDtos;
  }

  @Override
  public List<TeamStatsDto> getTeamStats() {
    return iplStatsRepo.findTeamStats();
  }

  @Override
  public List<RoleStatsDto> getRoleStats() {
    return iplStatsRepo.findRoleStats();
  }

  @Override
  public List<CountryStatsDto> getCountryStats() {
    return iplStatsRepo.findCountryStats();
  }
}
