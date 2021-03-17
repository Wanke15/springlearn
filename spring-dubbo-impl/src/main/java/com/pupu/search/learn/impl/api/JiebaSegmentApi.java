package com.pupu.search.learn.impl.api;

import com.pupu.search.learn.facade.api.IJiebaSegmentApi;
import com.pupu.search.learn.facade.dto.JiebaResponseDto;
import com.pupu.search.learn.impl.service.JiebaSegmentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
