package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

public class QuestionPojo {

	private Question columnQuestion;

	private Long columnDateBetwenQuestionComment;
	private Long columnDateBetwenQuestionAnswer;
	private Long columnDateBetwenCommentAnswer;

	private int columnCoerenciaTeD;
	private int columnTituloBemDefinido;
	private int columnExemplo;
	private int columnUsoNormaCultaLingua;
	private int columnEducacao;
	private int columnDetailContexto;
	private int columnDescricaoCurta;

	private int columnObjetividade;
	private int objShortDescription;
	private int objQuestionUnique;
	private int objAvoidMuchCode;

	private int columnClareza;
	private int claObjective;
	private int claCoherency;
	private int claShowExample;
	private int claQuestionUnique;
	private int claEvidentProbleam;

	private int columnPergBemDefinida;
	private int columnEvPerguntaDuplicada;
	private int columnEvPergSobreTrabAcademicos;

	public QuestionPojo() {
	}

	public Question getColumnQuestion() {
		return columnQuestion;
	}

	public void setColumnQuestion(Question columnQuestion) {
		this.columnQuestion = columnQuestion;
	}

	public int getColumnCoerenciaTeD() {
		return columnCoerenciaTeD;
	}

	public void setColumnCoerenciaTeD(int columnCoerenciaTeD) {
		this.columnCoerenciaTeD = columnCoerenciaTeD;
	}

	public int getColumnTituloBemDefinido() {
		return columnTituloBemDefinido;
	}

	public void setColumnTituloBemDefinido(int columnTituloBemDefinido) {
		this.columnTituloBemDefinido = columnTituloBemDefinido;
	}

	public int getColumnExemplo() {
		return columnExemplo;
	}

	public void setColumnExemplo(int columnExemplo) {
		this.columnExemplo = columnExemplo;
	}

	public int getColumnUsoNormaCultaLingua() {
		return columnUsoNormaCultaLingua;
	}

	public void setColumnUsoNormaCultaLingua(int columnUsoNormaCultaLingua) {
		this.columnUsoNormaCultaLingua = columnUsoNormaCultaLingua;
	}

	public int getColumnEducacao() {
		return columnEducacao;
	}

	public void setColumnEducacao(int columnEducacao) {
		this.columnEducacao = columnEducacao;
	}

	public int getColumnDetailContexto() {
		return columnDetailContexto;
	}

	public void setColumnDetailContexto(int columnDetailContexto) {
		this.columnDetailContexto = columnDetailContexto;
	}

	public int getColumnDescricaoCurta() {
		return columnDescricaoCurta;
	}

	public void setColumnDescricaoCurta(int columnDescricaoCurta) {
		this.columnDescricaoCurta = columnDescricaoCurta;
	}

	public int getColumnObjetividade() {
		return columnObjetividade;
	}

	public void setColumnObjetividade(int columnObjetividade) {
		this.columnObjetividade = columnObjetividade;
	}

	public int getColumnClareza() {
		return columnClareza;
	}

	public void setColumnClareza(int columnClareza) {
		this.columnClareza = columnClareza;
	}

	public int getColumnPergBemDefinida() {
		return columnPergBemDefinida;
	}

	public void setColumnPergBemDefinida(int columnPergBemDefinida) {
		this.columnPergBemDefinida = columnPergBemDefinida;
	}

	public int getColumnEvPerguntaDuplicada() {
		return columnEvPerguntaDuplicada;
	}

	public void setColumnEvPerguntaDuplicada(int columnEvPerguntaDuplicada) {
		this.columnEvPerguntaDuplicada = columnEvPerguntaDuplicada;
	}

	public int getColumnEvPergSobreTrabAcademicos() {
		return columnEvPergSobreTrabAcademicos;
	}

	public void setColumnEvPergSobreTrabAcademicos(
			int columnEvPergSobreTrabAcademicos) {
		this.columnEvPergSobreTrabAcademicos = columnEvPergSobreTrabAcademicos;
	}

	public Long getColumnDateBetwenQuestionComment() {
		return columnDateBetwenQuestionComment;
	}

	public void setColumnDateBetwenQuestionComment(
			Long columnDateBetwenQuestionComment) {
		this.columnDateBetwenQuestionComment = columnDateBetwenQuestionComment;
	}

	public Long getColumnDateBetwenQuestionAnswer() {
		return columnDateBetwenQuestionAnswer;
	}

	public void setColumnDateBetwenQuestionAnswer(
			Long columnDateBetwenQuestionAnswer) {
		this.columnDateBetwenQuestionAnswer = columnDateBetwenQuestionAnswer;
	}

	public Long getColumnDateBetwenCommentAnswer() {
		return columnDateBetwenCommentAnswer;
	}

	public void setColumnDateBetwenCommentAnswer(
			Long columnDateBetwenCommentAnswer) {
		this.columnDateBetwenCommentAnswer = columnDateBetwenCommentAnswer;
	}

	public int getObjShortDescription() {
		return objShortDescription;
	}

	public void setObjShortDescription(int objShortDescription) {
		this.objShortDescription = objShortDescription;
	}

	public int getObjQuestionUnique() {
		return objQuestionUnique;
	}

	public void setObjQuestionUnique(int objQuestionUnique) {
		this.objQuestionUnique = objQuestionUnique;
	}

	public int getObjAvoidMuchCode() {
		return objAvoidMuchCode;
	}

	public void setObjAvoidMuchCode(int objAvoidMuchCode) {
		this.objAvoidMuchCode = objAvoidMuchCode;
	}

	public int getClaObjective() {
		return claObjective;
	}

	public void setClaObjective(int claObjective) {
		this.claObjective = claObjective;
	}

	public int getClaCoherency() {
		return claCoherency;
	}

	public void setClaCoherency(int claCoherency) {
		this.claCoherency = claCoherency;
	}

	public int getClaShowExample() {
		return claShowExample;
	}

	public void setClaShowExample(int claShowExample) {
		this.claShowExample = claShowExample;
	}

	public int getClaQuestionUnique() {
		return claQuestionUnique;
	}

	public void setClaQuestionUnique(int claQuestionUnique) {
		this.claQuestionUnique = claQuestionUnique;
	}

	public int getClaEvidentProbleam() {
		return claEvidentProbleam;
	}

	public void setClaEvidentProbleam(int claEvidentProbleam) {
		this.claEvidentProbleam = claEvidentProbleam;
	}

}
