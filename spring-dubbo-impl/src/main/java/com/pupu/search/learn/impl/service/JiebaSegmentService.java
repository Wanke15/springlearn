package com.pupu.search.learn.impl.service;


import com.pupu.jieba.JiebaSegmenter;
import com.pupu.jieba.SegToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JiebaSegmentService {
    private static final JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();

    public List<String> segment(String text) {
        List<String> words = new ArrayList<>();
        List<SegToken> tokens = jiebaSegmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        for(SegToken segToken: tokens) {
            words.add(segToken.word);
        }
        return words;
    }
}
