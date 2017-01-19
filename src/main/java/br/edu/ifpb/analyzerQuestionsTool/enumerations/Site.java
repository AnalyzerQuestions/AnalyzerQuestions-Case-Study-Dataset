package br.edu.ifpb.analyzerQuestionsTool.enumerations;


/**
 * 
 */
/**
 * 
 * @author franck
 *
 */
public enum Site {

	/**
	 * Site starkoverflow em português
	 */
	STACK_OVERFLOW("pt.stackoverflow");

	private String site;

	/**
	 * 
	 * @param site
	 */
	private Site(String site) {
		this.site = site;
	}

	/**
	 * 
	 * @return
	 */
	public String getSite() {
		return site;
	}

}
