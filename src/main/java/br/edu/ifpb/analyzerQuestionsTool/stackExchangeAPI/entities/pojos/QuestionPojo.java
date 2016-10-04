package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

public class QuestionPojo {

	private Question columnQuestion;

	private int columnCoerenciaTeD;
	private int columnTituloBemDefinido;
	private int columnExemplo;
	private int columnUsoNormaCultaLingua;
	private int columnEducacao;
	private int columnDetailContexto;
	private int columnDescricaoCurta;
	private int columnObjetividade;
	private int columnClareza;
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

}
