package com.pupu.search.learn.facade.api;

import com.pupu.search.learn.facade.dto.JiebaBatchResponseDto;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;

import java.util.Collection;

public interface IJiebaSegmentApi {
    JiebaResponseDto segment(String text);

    JiebaBatchResponseDto segmentBatch(Collection<String> texts);

    JiebaBatchResponseDto segmentBatchAsync(Collection<String> texts);

}
