package ma.neoxia.common.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "messages";


	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
		System.setProperty("file.encoding", "UTF-8");
	}

	public static String getString(String key) {

		try {
			System.setProperty("file.encoding", "UTF-8");
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	/**
     * Reads a message from the resource bundle and format it using java MessageFormat.
     * @param key Message key.
     * @param parameters Parameters to pass to MessageFormat.format()
     * @return message String.
     */
    public static String getString(String key, Object[] parameters)
    {
        String baseMsg;
        try
        {
        	System.setProperty("file.encoding", "UTF-8");
            baseMsg = RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }

        return MessageFormat.format(baseMsg, parameters);
    }

    /**
     * Reads a message from the resource bundle and format it using java MessageFormat.
     * @param key Message key.
     * @param parameter single parameter to pass to MessageFormat.format()
     * @return message String.
     */
    public static String getString(String key, Object parameter)
    {
        return getString(key, new Object[]{parameter});
    }
}
