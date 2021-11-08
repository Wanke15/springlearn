package com.pupu.search.learn.impl.api;

import com.pupu.search.learn.facade.api.IJiebaSegmentApi;
import com.pupu.search.learn.facade.dto.JiebaBatchResponseDto;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;
import com.pupu.search.learn.impl.service.JiebaSegmentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service(interfaceClass = IJiebaSegmentApi.class)
@Component
public class JiebaSegmentApi implements IJiebaSegmentApi {
    @Autowired
    JiebaSegmentService jiebaSegmentService;

    @Override
    public JiebaResponseDto segment(String text) {
        List<String> words = jiebaSegmentService.segment(text);

        JiebaResponseDto jiebaResponseDto = new JiebaResponseDto();
        jiebaResponseDto.setWords(words);
        return jiebaResponseDto;
    }

    @Override
    public JiebaBatchResponseDto segmentBatch(Collection<String> texts) {
        long start = System.currentTimeMillis();

        List<List<String>> result = new ArrayList<>();
        for (String text: texts) {
            result.add(jiebaSegmentService.segment(text));
        }

        long stop = System.currentTimeMillis();
        JiebaBatchResponseDto jiebaBatchResponseDto = new JiebaBatchResponseDto();
        //jiebaBatchResponseDto.setResult(result);
        jiebaBatchResponseDto.setTimeConsumed(stop - start);
        return jiebaBatchResponseDto;
    }

    @Override
    public JiebaBatchResponseDto segmentBatchAsync(Collection<String> texts) {
        long start = System.currentTimeMillis();

        List<CompletableFuture<List<String>>> resultFutures = texts.stream().map(jiebaSegmentService::asyncSegment).collect(Collectors.toList());
        List<List<String>> result = resultFutures.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());

        long stop = System.currentTimeMillis();
        JiebaBatchResponseDto jiebaBatchResponseDto = new JiebaBatchResponseDto();
        //jiebaBatchResponseDto.setResult(result);
        jiebaBatchResponseDto.setTimeConsumed(stop - start);
        return jiebaBatchResponseDto;
    }
}
