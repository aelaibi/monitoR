package ma.neoxia.message.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import ma.neoxia.message.actions.base.JsonBaseAction;
import ma.neoxia.message.bean.ApplicationBean;
import ma.neoxia.message.bean.DomaineBean;
import ma.neoxia.message.bean.MessageBean;
import ma.neoxia.message.entities.Domaine;
import ma.neoxia.message.service.ApplicationService;
import ma.neoxia.message.service.DomaineService;
import ma.neoxia.message.service.MessageService;
import ma.neoxia.message.util.DateFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;

public class Message2ControllerAction extends JsonBaseAction {

	/**
	 * 
	 */
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private DomaineService domaineService;
	@Autowired
	private MessageService messageService;
	private List<ApplicationBean> gridApplications;
	private List<DomaineBean> gridDomaines;
	private List<MessageBean> gridModel = new ArrayList<MessageBean>();
	private TreeNode nodes = new TreeNode();
	private List<String> ids = new ArrayList<String>();
	private List<String> types = null;
	private Date firstDate;
	private Date lastDate;
	private String firstDatev;
	private String lastDatev;

	private int nbrMessages;

	private Integer rows = 0;
	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// get index row - i.e. user click to sort.
	private String sidx;
	// Your Total Pages
	private Integer total = 0;

	public String getFirstDatev() {
		return firstDatev;
	}

	public void setFirstDatev(String firstDatev) {
		this.firstDatev = firstDatev;
	}

	public String getLastDatev() {
		return lastDatev;
	}

	public void setLastDatev(String lastDatev) {
		this.lastDatev = lastDatev;
	}

	// All Record
	private Integer records = 0;

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

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public Integer getTotal() {
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

	public int getNbrMessages() {
		return nbrMessages;
	}

	public void setNbrMessages(int nbrMessages) {
		this.nbrMessages = nbrMessages;
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

	private static final long serialVersionUID = -5493895518741349394L;
	private final static Logger log = LoggerFactory
			.getLogger(Message2ControllerAction.class);

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public ApplicationService getApplicationService() {
		return applicationService;
	}

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public DomaineService getDomaineService() {
		return domaineService;
	}

	public void setDomaineService(DomaineService domaineService) {
		this.domaineService = domaineService;
	}

	public List<ApplicationBean> getGridApplications() {
		return gridApplications;
	}

	public void setGridApplications(List<ApplicationBean> gridApplications) {
		this.gridApplications = gridApplications;
	}

	public List<DomaineBean> getGridDomaines() {
		return gridDomaines;
	}

	public void setGridDomaines(List<DomaineBean> gridDomaines) {
		this.gridDomaines = gridDomaines;
	}

	public void setNodes(TreeNode nodes) {
		this.nodes = nodes;
	}

	public TreeNode getNodes() {
		return nodes;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> id) {
		this.ids = id;
	}

	public List<MessageBean> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<MessageBean> gridModel) {
		this.gridModel = gridModel;
	}

	public Collection<Value> getAllTypes() {
		Collection<Value> types = new Vector<Value>();

		Value value1 = new Value();
		value1.setCode("0");
		value1.setLibelle("All Types");
		types.add(value1);

		List<String> selectTypes = new ArrayList<String>();

		selectTypes = messageService.findDistinctTypes();

		for (String str : selectTypes) {
			Value value = new Value();
			value.setCode(str);
			value.setLibelle(str);
			types.add(value);
		}
		return types;
	}

	@Override
	public String execute() {
		log.info("Message2ControllerAction !");

		nodes.setId("Allmessages");
		nodes.setTitle("All messages");

		nodes.setState(TreeNode.NODE_STATE_LEAF);

		List<TreeNode> l = new ArrayList<TreeNode>();

		gridApplications = ApplicationBean.fromList(applicationService
				.findAll());

		Iterator<ApplicationBean> itr = gridApplications.iterator();
		while (itr.hasNext()) {

			ApplicationBean elm = itr.next();
			TreeNode nodes2 = new TreeNode();
			nodes2.setId("0" + elm.getNomApplication());
			nodes2.setTitle(elm.getNomApplication());
			nodes2.setState(TreeNode.NODE_STATE_LEAF);

			gridDomaines = new ArrayList<DomaineBean>();
			gridDomaines = DomaineBean.fromList(domaineService
					.findDomainesOfApplication(elm.getIdApplication(), null));

			Iterator<DomaineBean> itr2 = gridDomaines.iterator();

			List<TreeNode> l2 = new ArrayList<TreeNode>();

			while (itr2.hasNext()) {

				DomaineBean elm2 = itr2.next();
				TreeNode nodes3 = new TreeNode();
				nodes3.setId(elm2.getNomDomaine());
				// nodes3.setId(elm2.getIdDomaine().toString());

				nodes3.setTitle(elm2.getNomDomaine());

				nodes3.setState(TreeNode.NODE_STATE_LEAF);

				l2.add(nodes3);
				// nodes2.getChildren().add(nodes3);

			}

			nodes2.setChildren(l2);

			// get Domaines Of Application end

			l.add(nodes2);

			nodes.setChildren(l);
		}

		return SUCCESS;
	}

	public String displaySelected() {

		return SUCCESS;

	}

	public String messageList() {
		log.info("Message2ControllerAction messageList! ");
		Pageable requestPage = new PageRequest(page - 1, rows);

		gridModel = null;

		// /Dans le cas ou multiple est d�sactiv�
		if (types.get(0).equals("0")) {
			types = messageService.findDistinctTypes();
		}
		// /Dans le cas ou ids=null;
		if (ids.size() == 1 && ids.get(0).equals("")) {

			List<Domaine> alldomaines = domaineService.findAll();
			for (Domaine d : alldomaines) {
				ids.add(d.getNomDomaine());
			}
		}

		if (!firstDatev .equals("")  && !lastDatev.equals("") ) {
			firstDate = DateFormatter.string2Date(firstDatev, 0, 0);

			lastDate = DateFormatter.string2Date(lastDatev, 23, 59);

			gridModel = MessageBean.messageBeanFormatter(messageService
					.findByDateServerBetweenAndTypes(firstDate, lastDate,
							types, ids, requestPage));

			records = (int) messageService.findByDateServerBetweenAndTypes(
					firstDate, lastDate, types, ids).size();

		} else {
			
			gridModel = MessageBean.messageBeanFormatter(messageService
					.findByDateServerBetweenAndTypes(DateFormatter.FirstDate(), DateFormatter.LastDate(), types, ids,
							requestPage));
			records = (int) messageService.findByDateServerBetweenAndTypes(DateFormatter.FirstDate(), DateFormatter.LastDate(), types, ids).size();
		}
		// penser à ajouter le trie dans sql !! TODO
		// Collections.sort(gridModel, new MessageComparator());

		total = (int) Math.ceil((double) records / (double) rows);

		return SUCCESS;

	}

	public String nombreMessages() {
		log.info("Message2ControllerAction  nombreMessages !");
		// /Dans le cas ou multiple est d�sactiv�
		if (types.get(0).equals("0")) {
			types = messageService.findDistinctTypes();
		}
		// /Dans le cas ou ids=null;
		if (ids.size() == 1 && ids.get(0).equals("")) {

			List<Domaine> alldomaines = domaineService.findAll();
			for (Domaine d : alldomaines) {
				ids.add(d.getNomDomaine());
			}
		}

		if (firstDate != null && lastDate != null) {
			nbrMessages = messageService.findByDateServerBetweenAndTypes(
					firstDate, lastDate, types, ids).size();

		} else {
			

			nbrMessages = messageService.findByDateServerBetweenAndTypes(DateFormatter.FirstDate(), DateFormatter.LastDate(), types, ids).size();
		}

		return SUCCESS;
	}

}
