package com.pupu.search.learn.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString
public class JiebaBatchResponseDto implements Serializable {
    private List<List<String>> result;
    private Long timeConsumed;
}
