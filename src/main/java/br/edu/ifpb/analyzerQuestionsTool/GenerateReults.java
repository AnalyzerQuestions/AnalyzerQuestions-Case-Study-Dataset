package br.edu.ifpb.analyzerQuestionsTool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos.QuestionPojo;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Answer;
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
				
				qp.setColumnDateBetwenQuestionComment(this.dateBetwenQuestionComment(question));
				qp.setColumnDateBetwenQuestionAnswer(this.dateBetwenQuestionAnswer(question));
				qp.setColumnDateBetwenCommentAnswer(this.dateBetwenCommentAnswer(question));
				
				qp.setColumnCoerenciaTeD(analyzer.analyzerCoherencyBodyAndTitle(question.getTitle(), question.getBodyMarkdown()));
				qp.setColumnTituloBemDefinido(analyzer.analyzerUnderstandableTitle(question.getTitle(), question.getBodyMarkdown()));
				qp.setColumnExemplo(analyzer.analyzerShowExample(question.getBodyMarkdown()));
				qp.setColumnUsoNormaCultaLingua(analyzer.analyzerUsingProperLanguage(question.getBodyMarkdown()));
				qp.setColumnEducacao(analyzer.analyzerBeEducated(question.getBodyMarkdown()));
				qp.setColumnDetailContexto(analyzer.analyzerDetailAboutContext(question.getBodyMarkdown()));
				qp.setColumnDescricaoCurta(analyzer.analyzerShortDescriptionQuestion(question.getBodyMarkdown()));
				
				qp.setColumnObjetividade(analyzer.analyzerObjective(question.getBodyMarkdown()));
				qp.setObjShortDescription(analyzer.analyzerShortDescriptionQuestion(question.getBodyMarkdown()));
				qp.setObjQuestionUnique(analyzer.questionUnique(question.getBodyMarkdown()));
				qp.setObjAvoidMuchCode(analyzer.avoidingMuchCode(question.getBodyMarkdown()));
				
				
				qp.setColumnClareza(analyzer.analyzerClarity(question.getTitle(), question.getBodyMarkdown()));
				qp.setClaCoherency(analyzer.analyzerCoherencyBodyAndTitle(question.getTitle(), question.getBodyMarkdown()));
				qp.setClaEvidentProbleam(analyzer.isEvidentProbleam(question.getBodyMarkdown()));
				qp.setClaObjective(analyzer.analyzerObjective(question.getBodyMarkdown()));
				qp.setClaQuestionUnique(analyzer.questionUnique(question.getBodyMarkdown()));
				qp.setClaShowExample(analyzer.analyzerShowExample(question.getBodyMarkdown()));

				
				
				qp.setColumnPergBemDefinida(analyzer.analyzerUnderstandableDescription(question.getTitle(), question.getBodyMarkdown()));	
				qp.setColumnEvPerguntaDuplicada(analyzer.analyzerAvoidCreateDuplicateQuestion(this.parseComments(question.getComments())));
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
	
	private Long dateBetwenQuestionComment(Question question){
		Long minutes = -1l;
		Comment comment = null;
		
		if(isCommented(question)){
			comment = question.getComments().get(0);
			
			minutes = this.minutesBetewn(question.getCreationDate(), comment.getCreationDate());
		}
		return minutes;
	}
	
	private Long dateBetwenQuestionAnswer(Question question){
		Long minutes = -1l;
		Answer answer = null;
		
		if(isAnwend(question)){
			answer = question.getAnswers().get(0);
			
			minutes = this.minutesBetewn(question.getCreationDate(), answer.getCreationDate());
		}
		return minutes;
	}

	private Long dateBetwenCommentAnswer(Question question){
		Long minutes = -1l;
		
		if(isAnwend(question) && isCommented(question)){
			Answer answer = question.getAnswers().get(0);
			Comment comment = question.getComments().get(0);
			
			minutes = this.minutesBetewn(comment.getCreationDate(), answer.getCreationDate());
		}
		return minutes;
	}
	
	private Long minutesBetewn(Date date1, Date date2){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		
		Long minutes = (date2.getTime() - date1.getTime()) / (1000*60);
		
		return minutes;
	}
	
	private boolean isCommented(Question question){
		return question.getCommentCount() > 0; 
	}
	
	private boolean isAnwend(Question question){
		return question.isAnswered();
		
	}
}
