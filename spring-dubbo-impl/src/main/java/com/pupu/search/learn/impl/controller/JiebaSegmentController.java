package com.pupu.search.learn.impl.controller;


import com.pupu.search.learn.facade.api.IJiebaSegmentApi;
import com.pupu.search.learn.facade.dto.InputDto;
import com.pupu.search.learn.facade.dto.JiebaBatchResponseDto;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
;

@Slf4j
@RestController
public class JiebaSegmentController {
    @Autowired
    private IJiebaSegmentApi jiebaSegmentApi;

    @RequestMapping("/text/segment")
    public JiebaResponseDto segment(@RequestParam String text) {
        return jiebaSegmentApi.segment(text);
    }

    @PostMapping("/text/segmentBatch")
    public JiebaBatchResponseDto segmentBatch() {
        InputDto inputDto = new InputDto();
        return jiebaSegmentApi.segmentBatch(inputDto.getTexts());
    }

    @PostMapping("/text/segmentBatchAsync")
    public JiebaBatchResponseDto segmentBatchAsync() {
        InputDto inputDto = new InputDto();
        return jiebaSegmentApi.segmentBatchAsync(inputDto.getTexts());
    }
}
