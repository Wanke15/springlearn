package com.pupu.search.consumer;

import com.pupu.search.learn.facade.api.IJiebaSegmentApi;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiebaConsumer {
    @Reference
    private IJiebaSegmentApi jiebaSegmentApi;

    public List<String> consumerSegment(String text) {
        JiebaResponseDto words = jiebaSegmentApi.segment(text);
        return words.getWords();
    }
}
