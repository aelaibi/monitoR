package ma.ael.message.bean;

public class Return {
private String msg;
private Long code;
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Long getCode() {
	return code;
}
public void setCode(Long code) {
	this.code = code;
}
public Return(String msg, Long code) {
	super();
	this.msg = msg;
	this.code = code;
}

}
