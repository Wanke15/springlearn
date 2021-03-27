package com.pupu.search.learn.impl.controller;

import com.pupu.search.learn.facade.api.IJiebaSegmentApi;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiebaSegmentController {
    @Autowired
    private IJiebaSegmentApi jiebaSegmentApi;

    @RequestMapping("/text/segment")
    public JiebaResponseDto segment(@RequestParam String text) {
        return jiebaSegmentApi.segment(text);
    }

    @RequestMapping("/recommend")
    public Integer recommend() {
        return jiebaSegmentApi.getRecommendNum();
    }
}
