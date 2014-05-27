package ma.neoxia.message.actions.reporting;

import java.util.List;

public class ChartObject {

	private List<String> values;
	private String type;
	public ChartObject(List<String> values, String type) {
		super();
		this.values = values;
		this.type = type;
	}
	public ChartObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
