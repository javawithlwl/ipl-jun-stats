package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.CountryStatsDto;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleStatsDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class IplStatsController {

  private final IplStatsService iplStatService;

  @GetMapping("/team/names")
  public ResponseEntity<List<String>> getTeamNames() {
    return ResponseEntity.ok(iplStatService.getTeamNames());
  }

  @GetMapping("/players/{team}")
  public ResponseEntity<List<PlayerDto>> getPlayersByTeam(@PathVariable("team") String teamName) {
    return ResponseEntity.ok(iplStatService.getPlayersByTeam(teamName));
  }

  @GetMapping("/team/stats")
  public ResponseEntity<List<TeamStatsDto>> getTeamStats() {
    return ResponseEntity.ok(iplStatService.getTeamStats());
  }

  @GetMapping("/role/stats")
  public ResponseEntity<List<RoleStatsDto>> getRoleStats() {
    return ResponseEntity.ok(iplStatService.getRoleStats());
  }

  @GetMapping("/country/stats")
  public ResponseEntity<List<CountryStatsDto>> getCountryStats() {
    return ResponseEntity.ok(iplStatService.getCountryStats());
  }
}
