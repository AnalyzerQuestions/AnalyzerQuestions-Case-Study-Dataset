package br.edu.ifpb.analyzerQuestionsTool.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.analyzerQuestionsTool.GenerateReults;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.Response;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeApi;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeSite;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;
import br.edu.ifpb.analyzerQuestionsTool.util.data.CSVUtils;

public class StackExchangeApiTest {

	public static void main(String[] args) {

		StackExchangeApi api = new StackExchangeApi("KJi1v7aNWJ8aziMts2QEmQ((");
		api.authorize("gkTDYoP(Ar3ZGk64jkudSg))");
		
		Map<String, String> dates = new HashMap<String, String>();
		
		dates.put("1420070400", "1422748800");
		dates.put("1422835200", "1425168000");
		dates.put("1425254400", "1427846400");
		dates.put("1427932800", "1430438400");
		dates.put("1430524800", "1433116800");
		dates.put("1433203200", "1435708800");
		dates.put("1435795200", "1438387200");
		dates.put("1438473600", "1441065600");
		dates.put("1441152000", "1443657600");
		dates.put("1443744000", "1446336000");
		dates.put("1446422400", "1448928000");
		dates.put("1449014400", "1451606400");
		dates.put("1451692800", "1454284800");
		dates.put("1454371200", "1456790400");
		dates.put("1456876800", "1459468800"); //2016-04-01 <- parou aqui
		
		
		StackExchangeSite siteService = api.getSiteService(StackExchangeSite.STACK_OVERFLOW);
		Response<Question> response = null;
		List<Question> itemsQuestions = new ArrayList<Question>();
		
		if(siteService != null){
			for (String key : dates.keySet()) {
				api.dateBetwen(key, dates.get(key));
				response = siteService.getQuestions();
				System.out.println(response.getItems().size());
				for (Question question : response.getItems()) {
					itemsQuestions.add(question);
				}
			}
		}

		System.out.println("------------------------------------------------> 200 OK");
		System.out.println("------------------------------------------------> "+itemsQuestions.size()+" COUNT LIST");

		GenerateReults generateReults = new GenerateReults();
		CSVUtils csvUtils = new CSVUtils();
		csvUtils.getQuestions(generateReults.generate(itemsQuestions));
		csvUtils.writeCSV("dataset.csv");
		
		System.out.println("------------------------------------------------> ESCRITA CSV OK");


	}
}
