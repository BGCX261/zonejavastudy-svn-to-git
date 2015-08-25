import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.yan.dev.xmlbeans.CatalogDocument;
import com.yan.dev.xmlbeans.JournalDocument;

/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */

/**
 * Comment for Test.java
 * 
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-23 ÏÂÎç06:34:05
 */
public class Test {
	public static void main(String[] args) {
		File xmlfile = new File("xml\\catalog.xml");
		try {
			CatalogDocument catdoc = CatalogDocument.Factory.parse(xmlfile);
			JournalDocument.Journal[] journals = catdoc.getCatalog()
					.getJournalArray();
			for (JournalDocument.Journal j : journals)
				System.out.println(j.getArticle());
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
