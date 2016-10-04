package br.edu.ifpb.analyzerQuestionsTool.util.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos.QuestionPojo;

public class CSVUtils {
	
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private List<QuestionPojo> questions;

	private CSVPrinter csvPrinter;
    
    private static final Object [] FILE_HEADER =
    	{"ID PERGUNTA","ID RESPOSTA ACEITA","QUANTIDADE DE RESPOSTAS","FECHADA", "DATA FECHAMENTO", "QUANTIDADE COMENTÁRIO", 
    	"DATA CRIAÇÃO", "FOI RESPONDIDA", "ÚLTIMA DATA DE EDIÇÃO", "PONTOS", "TAGS", "TITLE", "QUANTIDADE VISUALIZAÇÕES", "DESCRIÇAO", "QUANTIDADADE DE VOTOS (down)",
    	"FOI VOTADA (down)", "QUANTIDADE DE VOTOS (up)", "QUANTIDADE DE VOTOS DELETADOS", "FOI VOTADA (up)", "TÍTULO BEM DEFINIDO", "TÍTULO MÉDIO",
    	"TITULO TOTALMENTE EM CAIXA ALTA", "TÍTULO PARCIALMENTE EM CAIXA ALTA", "COERÊNCIA DO TÍTULO COM DESCRIÇÃO",
    	"DESCRIÇÃO BEM DEFINIDA", "INCLUIR VOCATIVO", "DESCRIÇÃO CURTA", "DESCRIÇÃO LONGA",
    	"MOSTRAR EXEMPLO", "EVITAR MUITO CÓDIGO", "EVITAR DESCRIÇÃO COM APENAS CÓDIGO", "PERGUNTA COM ÚNICO PROBLEMA",
    	"INCLUIR AGRADECIMENTO", "EVITAR SER EXIGENTE/MAL EDUCADO", "USO DA PRÓPRIA LINGUA", "EVITAR CRIAR PERGUNTAS FACTUAIS",
    	"NÃO CRIAR PERGUNTAS DE CASA/AULA/TRABALHO", "DEMOSTRAR INTERESSE", "CONTER LOG DE ERRO"};
    
    
    public void getQuestions(List<QuestionPojo> questions){
    	this.questions = questions;
    }
    
    
    public void writeCSV(String fileName){
    	
    	FileWriter fWriter = null;
    	
    	CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
    	
    	try {
			fWriter = new FileWriter(fileName);
			csvPrinter = new CSVPrinter(fWriter, csvFormat);
			csvPrinter.printRecord(FILE_HEADER);
			System.out.println(questions.size());
			for (QuestionPojo q : questions) {
		    	List recordQuestions = new ArrayList();
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getQuestionId()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getAcceptedAnswerId()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getAnswerCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isCanClosed()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getClosedDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCommentCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getCreationDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isAnswered()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getLastEditDate()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getScore()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTags()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getTitle()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getViewCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getBodyMarkdown()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getDownVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isDownVoted()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getUpVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().getDeleteVoteCount()));
				recordQuestions.add(String.valueOf(q.getColumnQuestion().isUpVoted()));
				
				recordQuestions.add(String.valueOf(q.getColumnUnderstandableTitle()));
				recordQuestions.add(String.valueOf(q.getColumnMediumSizeTitle()));
				recordQuestions.add(String.valueOf(q.getColumnTitleCapitaLetters()));
				recordQuestions.add(String.valueOf(q.getColumnTitleCapitaLettersPartially()));
				recordQuestions.add(String.valueOf(q.getColumnCoherencyBodyAndTitle()));
				recordQuestions.add(String.valueOf(q.getColumnUnderstandableDescription()));
				recordQuestions.add(String.valueOf(q.getColumnIncludingVocative()));
				recordQuestions.add(String.valueOf(q.getColumnShortDescription()));
				recordQuestions.add(String.valueOf(q.getColumnLongDescription()));
				recordQuestions.add(String.valueOf(q.getColumnShowingExample()));
				recordQuestions.add(String.valueOf(q.getColumnAvoidingMuchCode()));
				recordQuestions.add(String.valueOf(q.getColumnAvoidDescriptionWithCodeOnly()));
				recordQuestions.add(String.valueOf(q.getColumnQuestionWithSingleProblem()));
				recordQuestions.add(String.valueOf(q.getColumnIncludingGreetings()));
				recordQuestions.add(String.valueOf(q.getColumnObviatingDemandingLanguage()));
				recordQuestions.add(String.valueOf(q.getColumnUsingProperLanguage()));
				recordQuestions.add(String.valueOf(q.getColumnAvoidingCreatingFactoidQuestions()));
				recordQuestions.add(String.valueOf(q.getColumnDoNotCreateHomeworkQuestions()));
				recordQuestions.add(String.valueOf(q.getColumnDemonstrateInterest()));
				recordQuestions.add(String.valueOf(q.getColumncontainsLog()));
				
				csvPrinter.printRecord(recordQuestions);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fWriter.flush();
				fWriter.close();
				csvPrinter.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
    }
}
