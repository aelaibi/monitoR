package ma.ael.message.dto.comparator;

import java.util.Comparator;

import org.springframework.util.Assert;

import ma.ael.message.bean.MessageBean;

public class MessageComparator implements Comparator<MessageBean> {


	@Override
	public int compare(MessageBean arg0, MessageBean arg1) {
		Assert.notNull(arg0);
		Assert.notNull(arg1);
		int ret = 0;
		ret = arg0.getNomApplication().compareTo(arg1.getNomApplication());
		if(ret == 0){
			ret = arg0.getNomDomaine().compareTo(arg1.getNomDomaine());
			if(ret == 0){
				ret = arg0.getType().compareTo(arg1.getType());
				if(ret == 0){
					ret = arg0.getDateServer().compareTo(arg1.getDateServer());
				}
			}
		}
		
		
		return ret;
	}

}
