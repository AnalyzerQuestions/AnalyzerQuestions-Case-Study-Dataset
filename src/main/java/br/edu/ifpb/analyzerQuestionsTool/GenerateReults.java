package br.edu.ifpb.analyzerQuestionsTool;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos.QuestionPojo;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Comment;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

public class GenerateReults {
	
	private QuestionAnalyzerFinal analyzer;
	
	
	public GenerateReults() {
		analyzer = new QuestionAnalyzerFinal();
	}
	
	public List<QuestionPojo> generate(List<Question> questions){
		
		List<QuestionPojo> questionPojos = new ArrayList<QuestionPojo>();
		
		for (Question question : questions) {
			
			QuestionPojo qp = new QuestionPojo();
			qp.setColumnQuestion(question);
			
			qp.setColumnCoerenciaTeD(analyzer.analyzerCoherencyBodyAndTitle(question.getTitle(), question.getBodyMarkdown()));
			qp.setColumnTituloBemDefinido(analyzer.analyzerUnderstandableTitle(question.getTitle(), question.getBodyMarkdown()));
			qp.setColumnExemplo(analyzer.analyzerShowExample(question.getBodyMarkdown()));
			qp.setColumnUsoNormaCultaLingua(analyzer.analyzerUsingProperLanguage(question.getBodyMarkdown()));
			qp.setColumnEducacao(analyzer.analyzerBeEducated(question.getBodyMarkdown()));
			qp.setColumnDetailContexto(analyzer.analyzerDetailAboutContext(question.getBodyMarkdown()));
			qp.setColumnDescricaoCurta(analyzer.analyzerShortDescriptionQuestion(question.getBodyMarkdown()));
			qp.setColumnObjetividade(analyzer.analyzerObjective(question.getBodyMarkdown()));
			qp.setColumnClareza(analyzer.analyzerClarity(question.getTitle(), question.getBodyMarkdown()));
			qp.setColumnPergBemDefinida(analyzer.analyzerUnderstandableDescription(question.getTitle(), question.getBodyMarkdown()));
				
			qp.setColumnEvPerguntaDuplicada(analyzer.analyzerAvoidCreateDuplicateQuestion(
															this.parseComments(question.getComments())));
			
			qp.setColumnEvPergSobreTrabAcademicos(analyzer.analyzerDoNotCreateHomeworkQuestions(question.getBodyMarkdown()));
			
			questionPojos.add(qp);
		}
		
		return questionPojos;
	}
	
	private List<String> parseComments(List<Comment> comments){
		List<String> bodys = new ArrayList<>();
		if(comments != null){
			for (Comment comment : comments) {
				bodys.add(comment.getBodyMarkdown());
			}
		}
		return bodys;
	}
	

}
