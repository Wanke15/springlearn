package com.pupu.search.learn.impl.service;


import com.pupu.jieba.JiebaSegmenter;
import com.pupu.jieba.SegToken;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class JiebaSegmentService {
    private static final JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();

    @SneakyThrows
    public List<String> segment(String text) {
        List<String> words = new ArrayList<>();
        List<SegToken> tokens = jiebaSegmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        for(SegToken segToken: tokens) {
            words.add(segToken.word);
        }
//        Thread.sleep(10);
        return words;
    }

    @SneakyThrows
    @Async
    public CompletableFuture<List<String>> asyncSegment(String text) {
        List<String> words = new ArrayList<>();
        List<SegToken> tokens = jiebaSegmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        for(SegToken segToken: tokens) {
            words.add(segToken.word);
        }
//        Thread.sleep(10);
        return CompletableFuture.completedFuture(words);
    }
}
