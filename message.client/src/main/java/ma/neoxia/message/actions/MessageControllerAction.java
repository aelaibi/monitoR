package ma.neoxia.message.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ma.neoxia.message.actions.base.JsonBaseAction;
import ma.neoxia.message.bean.MessageBean;
import ma.neoxia.message.dto.comparator.MessageComparator;
import ma.neoxia.message.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageControllerAction extends JsonBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493895518741349394L;
	private final static Logger log = LoggerFactory
			.getLogger(MessageControllerAction.class);

	@Autowired
	MessageService messageService;

	private List<MessageBean> gridModel = new ArrayList<MessageBean>();
	private Date firstDate;
	private Date lastDate;

	@Override
	public String execute() {
		
		gridModel = MessageBean.messageBeanFormatter(messageService
				.findByDateServerBetween(firstDate, lastDate));
		
		// penser à ajouter le trie dans sql !! TODO
		Collections.sort(gridModel, new MessageComparator());
		setRecords(gridModel.size());
		
		log.info("MessageAction !");
		return SUCCESS;
	}

	public String messageList() {
		gridModel = MessageBean.messageBeanFormatter(messageService
				.findByDateServerBetween(firstDate, lastDate));
		
		// penser à ajouter le trie dans sql !! TODO
		Collections.sort(gridModel, new MessageComparator());
		setRecords(gridModel.size());
		return SUCCESS;
	}

	// public String messageListWithDate() {
	// gridModel = MessageBean.messageBeanFormatter(
	// messageDao.findByDateServerBetween(firstDate, lastDate) );
	// return SUCCESS;
	// }

	public List<MessageBean> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<MessageBean> gridModel) {
		this.gridModel = gridModel;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

}
