package ma.ael.message.actions.base;

import ma.ael.message.commun.action.MessageAction;



public class JsonBaseAction extends MessageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	protected Integer rows = 0;
	
	// Get the requested page. By default grid sets this to 1.
	protected Integer page = 0;
	// sorting order - asc or desc
	protected String sord;
	// get index row - i.e. user click to sort.
	protected String sidx;
	// Your Total Pages
	protected Integer total = 0;
	// All Record
	protected Integer records = 0;


	
	
	
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public Integer getTotal() {
		if(total != null && total.equals(Integer.valueOf(0))) {
			total = 1;
		}
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	

}