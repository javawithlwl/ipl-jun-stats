package com.careerit.iplstats.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CountryStatsDto {
    private String countryName;
    private long count;
}
