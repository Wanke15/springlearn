package com.pupu.search.learn.facade.api;

import com.pupu.search.learn.facade.dto.JiebaResponseDto;

public interface IJiebaSegmentApi {
    JiebaResponseDto segment(String text);
    Integer getRecommendNum();
}
