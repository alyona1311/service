package ru.textanalysis.abstractservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.library.text.word.Word;
import ru.textanalysis.tfwwt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tfwwt.jmorfsdk.load.JMorfSdkLoad;
import summarizaton.MethodsOfSummarization;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SummaryService {

    @Autowired
    private MorfologyService morfologyService;

    @Autowired
    public SummaryService(){
    }

    public String getSummary(String fullText) {
        // Логика получения реферата и ключевых слов
        MethodsOfSummarization ms = new MethodsOfSummarization();
        Map<Integer, String> summaryMap = ms.getReferatOfMethodStatistic(fullText, 30);
        String summary = ms.getReferatToString(summaryMap);

        //JMorfSdk jMorfSdk = morfologyService.getjMorfSdk();
        //jMorfSdk.getMorfologyCharacteristics("столов");

        return summary;
    }

    public List<Word> getKeyWords (String fullText) {
        MethodsOfSummarization ms = new MethodsOfSummarization();
        List<Word> keyWords = ms.getKeyWords(fullText);
        return keyWords;
    }
}
