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
    
    private static final Object [] FILE_HEADER = {
    	"ID PERGUNTA",
    	"ID RESPOSTA ACEITA",
    	"QUANTIDADE DE RESPOSTAS",
    	"FECHADA", 
    	"DATA FECHAMENTO", 
    	"QUANTIDADE COMENTÁRIO", 
    	"DATA CRIAÇÃO", 
    	"FOI RESPONDIDA", 
    	"ÚLTIMA DATA DE EDIÇÃO", 
    	"PONTOS", 
    	"TAGS", 
    	"TITLE", 
    	"QUANTIDADE VISUALIZAÇÕES", 
    	"DESCRIÇAO", 
    	"QUANTIDADADE DE VOTOS (down)",
    	"FOI VOTADA (down)",
    	"QUANTIDADE DE VOTOS (up)", 
    	"QUANTIDADE DE VOTOS DELETADOS",
    	"FOI VOTADA (up)",
    	
		"COERENCIA ENTRE TITULO E DESCRICAO",
		"TITULO BEM DEFINIDO",
		"EXEMPLO",
		"USO DA NORMA CULTA",
		"SER EDUCADO",
		"DETALHE DO CONTEXTO DO PROBLEMA",
		"DESCRICAO CURTA",
		"OBJETIVIDADE",
		"CLAREZA", 
		"PERGUNTA BEM DEFINIDA", 
		"EVITAR CRIAR PERGUNTAS DUPLICADAS", 
		"EVITAR CRIAR PERGUNTAS SOBRE TARABALHOS ACADEMICOS",
	};
    
    
    public void getQuestions(List<QuestionPojo> questions){
    	this.questions = questions;
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
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
				
				recordQuestions.add(String.valueOf(q.getColumnCoerenciaTeD()));
				recordQuestions.add(String.valueOf(q.getColumnTituloBemDefinido()));
				recordQuestions.add(String.valueOf(q.getColumnExemplo()));
				recordQuestions.add(String.valueOf(q.getColumnUsoNormaCultaLingua()));
				recordQuestions.add(String.valueOf(q.getColumnEducacao()));
				recordQuestions.add(String.valueOf(q.getColumnDetailContexto()));
				recordQuestions.add(String.valueOf(q.getColumnDescricaoCurta()));
				recordQuestions.add(String.valueOf(q.getColumnObjetividade()));
				recordQuestions.add(String.valueOf(q.getColumnClareza()));
				recordQuestions.add(String.valueOf(q.getColumnPergBemDefinida()));
				recordQuestions.add(String.valueOf(q.getColumnEvPerguntaDuplicada()));
				recordQuestions.add(String.valueOf(q.getColumnEvPergSobreTrabAcademicos()));
				
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
