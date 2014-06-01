package ma.ael.message.actions.ref;

import java.util.List;

import ma.ael.message.actions.base.JsonBaseAction;
import ma.ael.message.bean.RoleBean;
import ma.ael.message.service.HabilitationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleAction extends JsonBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493895518741349394L;
	private final static Logger LOOGER = LoggerFactory.getLogger(RoleAction.class);
	
	@Autowired
	private HabilitationService habService;
	private List<RoleBean> gridModel;
	
	public String index() {
		LOOGER.info( "RoleAction Index !" );
		return SUCCESS;
	}
	
	public String list() {
		LOOGER.info( "RoleAction list !" );
		gridModel = RoleBean.fromList(habService.findAllRoles());
		
		setRecords(gridModel.size());
		setTotal( (int) Math.ceil((double)getRecords() / (double)getRows()) );
		
		LOOGER.debug("liste role {}", getRecords());
		return SUCCESS;
	}
	public String edit() {
		LOOGER.info( "RoleAction edit !" );
		return SUCCESS;
	}

	/**
	 * @return the gridModel
	 */
	public List<RoleBean> getGridModel() {
		return gridModel;
	}
	/**
	 * @param gridModel the gridModel to set
	 */
	public void setGridModel(List<RoleBean> gridModel) {
		this.gridModel = gridModel;
	}
	
}
