package br.edu.ifpb.analyzerQuestionsTool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.analyzerQuestionsTool.analyzers.QuestionAnalyzerPaperFinal;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos.QuestionPojo;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Answer;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Comment;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

/**
 * 
 * <p>
 * 		<b> Gera resultados para dataset </b>
 * </p>
 *
 * <p>
 * Adicionar metadados do SO e gera resultados a partir
 * dos analizadores para Dataset.
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class GenerateReults {
	
	/**
	 * 
	 */
	private QuestionAnalyzerFinal analyzer;
	
	/**
	 * 
	 */
	private QuestionAnalyzerPaperFinal analyzerPaper;
	
	
	/**
	 * 
	 */
	public GenerateReults() {
		analyzer = new QuestionAnalyzerFinal();
		analyzerPaper = new QuestionAnalyzerPaperFinal();
	}
	
	/**
	 * 
	 * @param questions
	 * @return
	 */
	public List<QuestionPojo> generate(List<Question> questions){
		
		List<QuestionPojo> questionPojos = new ArrayList<QuestionPojo>();
		
		for (Question question : questions) {
			if(!question.isAnswered()){
				QuestionPojo qp = new QuestionPojo();
				
					/**
					 * metadados SO request to API
					 */
					qp.setColumnQuestion(question);
					
					/**
					 * metadados of time asks
					 */
					qp.setColumnDateBetwenQuestionComment(this.dateBetwenQuestionComment(question));
					qp.setColumnDateBetwenQuestionAnswer(this.dateBetwenQuestionAnswer(question));
					qp.setColumnDateBetwenCommentAnswer(this.dateBetwenCommentAnswer(question));
					
					/**
					 * Analizers of questions obtained requesties in SO for paper of Journal submit
					 */
					qp.setColumnObjetividade(analyzerPaper.analyzerObjective(question.getBodyMarkdown()));
					qp.setColumnQuestionUnique(analyzer.questionUnique(question.getBodyMarkdown()));
					qp.setColumnDescricaoCurta(analyzer.analyzerShortDescriptionQuestion(question.getBodyMarkdown()));
					
					qp.setColumnClareza(analyzerPaper.analyzerClarity(question.getTitle(), question.getBodyMarkdown()));
					qp.setColumnCoerenciaTeD(analyzer.analyzerCoherencyBodyAndTitle(question.getTitle(), question.getBodyMarkdown()));
					qp.setColumnEvidentProbleam(analyzer.isEvidentProbleam(question.getBodyMarkdown()));
	
					qp.setColumnPergBemDefinida(analyzerPaper.analyzerUnderstandableDescription(question.getTitle(), question.getBodyMarkdown()));	
					qp.setColumnExemplo(analyzer.analyzerShowExample(question.getBodyMarkdown()));
					qp.setColumnMuchCode(analyzerPaper.analyzerMuchCodeOrOnlyCode(question.getBodyMarkdown()));
					
					qp.setColumnEducacao(analyzerPaper.analyzerBeEducated(question.getBodyMarkdown(), this.parseComments(question.getComments())));
					qp.setColumnEvPerguntaDuplicada(analyzer.analyzerAvoidCreateDuplicateQuestion(this.parseComments(question.getComments())));
					qp.setColumnEvPergSobreTrabAcademicos(analyzer.analyzerDoNotCreateHomeworkQuestions(question.getBodyMarkdown()));
					qp.setColumnAgradecimento(analyzer.includingGreetings(question.getBodyMarkdown()));
					qp.setColumnUsoNormaCultaLingua(analyzer.analyzerUsingProperLanguage(question.getBodyMarkdown()));
					
					
					questionPojos.add(qp);
			}
		}
		
		return questionPojos;
	}
	
	/**
	 * Parse list of comments of pojo @Comment to list String
	 * @param comments
	 * @return
	 */
	private List<String> parseComments(List<Comment> comments){
		List<String> bodys = new ArrayList<>();
		if(comments != null){
			for (Comment comment : comments) {
				bodys.add(comment.getBodyMarkdown());
			}
		}
		return bodys;
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	private Long dateBetwenQuestionComment(Question question){
		Long minutes = -1l;
		Comment comment = null;
		
		if(isCommented(question)){
			comment = question.getComments().get(0);
			
			minutes = this.minutesBetewn(question.getCreationDate(), comment.getCreationDate());
		}
		return minutes;
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	private Long dateBetwenQuestionAnswer(Question question){
		Long minutes = -1l;
		Answer answer = null;
		
		if(isAnwend(question)){
			answer = question.getAnswers().get(0);
			
			minutes = this.minutesBetewn(question.getCreationDate(), answer.getCreationDate());
		}
		return minutes;
	}

	/**
	 * 
	 * @param question
	 * @return
	 */
	private Long dateBetwenCommentAnswer(Question question){
		Long minutes = -1l;
		
		if(isAnwend(question) && isCommented(question)){
			Answer answer = question.getAnswers().get(0);
			Comment comment = question.getComments().get(0);
			
			minutes = this.minutesBetewn(comment.getCreationDate(), answer.getCreationDate());
		}
		return minutes;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	private Long minutesBetewn(Date date1, Date date2){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		
		Long minutes = (date2.getTime() - date1.getTime()) / (1000*60);
		
		return minutes;
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	private boolean isCommented(Question question){
		return question.getCommentCount() > 0; 
	}
	
	private boolean isAnwend(Question question){
		return question.isAnswered();
		
	}
}
