package ma.ael.message.dto;
//package ma.ael.message.dto;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import ma.ael.message.bean.MessageBean;
//import ma.ael.message.dto.comparator.MessageComparator;
//import ma.ael.message.entities.Message;
//import ma.ael.message.entities.TypeMessage;
//
//public class Mockers {
//
//	public static void updateTyp(List<Message> gridModel) {
////		gridModel = MessageBean.messageBeanFormatter( messageDao.findByDateServerBetween(firstDate, lastDate) );
////		int cpt = 0;
////		for (MessageBean msg : gridModel) {
////			cpt++;
////			Message message = new Message();
//////			Long id = new Long(msg.getIdMessage());
//////			message = messageDao.findOne(id);
////			message = messageDao.findByIdMessage(msg.getIdMessage());
////			switch (cpt) {
////			case 1:
////				message.setType(TypeMessage.WARNING.name());
////				break;
////			case 2:
////				message.setType(TypeMessage.INFO.name());
////				break;
////			case 3:
////				message.setType(TypeMessage.WARNING.name());
////				break;
////			case 4:
////				message.setType(TypeMessage.ERROR.name());
////				break;
////			}
////			messageDao.setNewTypeForMessage(message.getType(), message.getIdMessage());
////		}
//	}
//	
//	public static List<MessageBean> getMock1() {
//		List<MessageBean> listMessage = new ArrayList<MessageBean>();
//		
//		// messages
//		MessageBean msg1 = new MessageBean();
//		MessageBean msg2 = new MessageBean();
//		MessageBean msg3 = new MessageBean();
//		MessageBean msg4 = new MessageBean();
//		MessageBean msg5 = new MessageBean();
//		MessageBean msg6 = new MessageBean();
//		MessageBean msg7 = new MessageBean();
//		MessageBean msg8 = new MessageBean();
//		MessageBean msg9 = new MessageBean();
//		MessageBean msg10 = new MessageBean();
//		
//		Date date = new Date();
//		Calendar cal = Calendar.getInstance();
//
//		msg5.setIdMessage(Long.valueOf(5));
//		msg5.setType(TypeMessage.ERROR.name());
//		msg5.setMessage("message courrier 2...");
//		msg5.setDescription("description ......");
//		cal.set(2013, 01, 14, 12, 00);
//		date = cal.getTime();
//		msg5.setDateServer(date);
//		msg5.setIdDomaine(Long.valueOf(5));
//		msg5.setNomDomaine("Domaine");
//		msg5.setIdApplication(3);
//		msg5.setNomApplication("Courrier");
//		listMessage.add(msg5);
//		
//		msg1.setIdMessage(Long.valueOf(1));
//		msg1.setType(TypeMessage.WARNING.name());
//		msg1.setMessage("message followatch 1.....");
//		msg1.setDescription("description ......");
//		cal.set(2013, 01, 18, 12, 00);
//		date = cal.getTime();
//		msg1.setDateServer(date);
//		msg1.setIdDomaine(1);
//		msg1.setNomDomaine("Rest");
//		msg1.setIdApplication(1);
//		msg1.setNomApplication("Followatch");
//		listMessage.add(msg1);
//
//		msg3.setIdMessage(Long.valueOf(3));
//		msg3.setType(TypeMessage.ERROR.name());
//		msg3.setMessage("message fullzap 1...");
//		msg3.setDescription("description ......");
//		cal.set(2013, 01, 16, 12, 00);
//		date = cal.getTime();
//		msg3.setDateServer(date);
//		msg3.setIdDomaine(3);
//		msg3.setNomDomaine("Radio");
//		msg3.setIdApplication(2);
//		msg3.setNomApplication("FullZap");
//		listMessage.add(msg3);
//		
//		msg4.setIdMessage(Long.valueOf(4));
//		msg4.setType(TypeMessage.WARNING.name());
//		msg4.setMessage("message courrier 1...");
//		msg4.setDescription("description ......");
//		cal.set(2013, 01, 15, 12, 00);
//		date = cal.getTime();
//		msg4.setDateServer(date);
//		msg4.setIdDomaine(4);
//		msg4.setNomDomaine("Client");
//		msg4.setIdApplication(3);
//		msg4.setNomApplication("Courrier");
//		listMessage.add(msg4);
//
//		msg2.setIdMessage(Long.valueOf(2));
//		msg2.setType(TypeMessage.INFO.name());
//		msg2.setMessage("message followatch 2...");
//		msg2.setDescription("description ......");
//		cal.set(2013, 01, 17, 12, 00);
//		date = cal.getTime();
//		msg2.setDateServer(date);
//		msg2.setIdDomaine(2);
//		msg2.setNomDomaine("Redis");
//		msg2.setIdApplication(1);
//		msg2.setNomApplication("Followatch");
//		listMessage.add(msg2);
//		
//		msg6.setIdMessage(Long.valueOf(6));
//		msg6.setType(TypeMessage.WARNING.name());
//		msg6.setMessage("message courrier 3...");
//		msg6.setDescription("description ......");
//		cal.set(2013, 01, 12, 12, 00);
//		date = cal.getTime();
//		msg6.setDateServer(date);
//		msg6.setIdDomaine(6);
//		msg6.setNomDomaine("Commun");
//		msg6.setIdApplication(3);
//		msg6.setNomApplication("Courrier");
//		listMessage.add(msg6);
//		
//		msg7.setIdMessage(Long.valueOf(7));
//		msg7.setType(TypeMessage.ERROR.name());
//		msg7.setMessage("message fullzap 1...");
//		msg7.setDescription("description ......");
//		cal.set(2013, 01, 18, 15, 00);
//		date = cal.getTime();
//		msg7.setDateServer(date);
//		msg7.setIdDomaine(7);
//		msg7.setNomDomaine("Press");
//		msg7.setIdApplication(2);
//		msg7.setNomApplication("FullZap");
//		
//		
//		msg8.setIdMessage(Long.valueOf(8));
//		msg8.setType(TypeMessage.ERROR.name());
//		msg8.setMessage("message courrier 8...");
//		msg8.setDescription("description ......");
//		cal.set(2013, 01, 16, 16, 00);
//		date = cal.getTime();
//		msg8.setDateServer(date);
//		msg8.setIdDomaine(5);
//		msg8.setNomDomaine("Domaine");
//		msg8.setIdApplication(3);
//		msg8.setNomApplication("Courrier");
//		listMessage.add(msg8);
//		
//		msg9.setIdMessage(Long.valueOf(9));
//		msg9.setType(TypeMessage.WARNING.name());
//		msg9.setMessage("message courrier 9...");
//		msg9.setDescription("description ......");
//		cal.set(2013, 01, 19, 16, 00);
//		date = cal.getTime();
//		msg9.setDateServer(date);
//		msg9.setIdDomaine(6);
//		msg9.setNomDomaine("Commun");
//		msg9.setIdApplication(3);
//		msg9.setNomApplication("Courrier");
//		listMessage.add(msg9);
//		
//		msg10.setIdMessage(Long.valueOf(10));
//		msg10.setType(TypeMessage.ERROR.name());
//		msg10.setMessage("message courrier 8...");
//		msg10.setDescription("description ......");
//		cal.set(2013, 01, 16, 16, 00);
//		date = cal.getTime();
//		msg10.setDateServer(date);
//		msg10.setIdDomaine(5);
//		msg10.setNomDomaine("Domaine");
//		msg10.setIdApplication(3);
//		msg10.setNomApplication("Courrier");
//		listMessage.add(msg10);
//		
//		listMessage.add(msg10);
//		
//		
//		return groupedList(listMessage);
//
//	}
//	
//	public static List<MessageBean> groupedList(List<MessageBean> listMessage) {
//		
//		Collections.sort(listMessage, new MessageComparator());
//		return listMessage;
//	}
//	
//	
//	
//	
//}
