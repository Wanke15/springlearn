package com.pupu.search.controller;

import com.pupu.search.consumer.JiebaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ResponseBody
@RestController
public class ConsumerController {
    @Autowired
    JiebaConsumer jiebaConsumer;

    @RequestMapping("/consumer/jiebaseg")
    public List<String> jiebaSeg(@RequestParam String text) {
        return jiebaConsumer.consumerSegment(text);
    }
}
