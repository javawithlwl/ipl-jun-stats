package com.careerit.iplstats.dao;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.CountryStatsDto;
import com.careerit.iplstats.dto.RoleStatsDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IplStatsRepo extends JpaRepository<Player,Long> {

    @Query("select distinct p.team from Player p")
    List<String> findTeamNames();
    List<Player> findByTeam(String team);
    @Query("select new com.careerit.iplstats.dto.TeamStatsDto(p.team,sum(p.amount)) from Player p group by p.team")
    List<TeamStatsDto> findTeamStats();
    @Query("select new com.careerit.iplstats.dto.RoleStatsDto(p.role,sum(p.amount)) from Player p group by p.role")
    List<RoleStatsDto> findRoleStats();
    @Query("select new com.careerit.iplstats.dto.CountryStatsDto(p.country,count(*)) from Player p group by p.country")
    List<CountryStatsDto> findCountryStats();
}
