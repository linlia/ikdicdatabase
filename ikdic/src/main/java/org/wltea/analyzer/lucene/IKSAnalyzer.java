package org.wltea.analyzer.lucene;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.ClasspathResourceLoader;
import org.apache.solr.core.SolrResourceLoader;

public class IKSAnalyzer  extends Analyzer {

	private IKSynonymFilterFactory syfilter=null;
	Map<String, String> argsMap=null;
	 public IKSAnalyzer() {
		argsMap = new HashMap<String, String>();
		argsMap.put("expand", "true");
		argsMap.put("synonyms", "synonyms.txt");
		argsMap.put("autoupdate", "false");
		argsMap.put("flushtime", "10");
		try {
			syfilter=new IKSynonymFilterFactory(argsMap);
			syfilter.inform(new ClasspathResourceLoader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected TokenStreamComponents createComponents(String arg0, Reader arg1) {
		
		Tokenizer _IKTokenizer = new IKTokenizer(arg1 , true);
		 
		TokenStream tokenstream= syfilter.create(_IKTokenizer);
		return new TokenStreamComponents(_IKTokenizer, tokenstream);
		 
	}
	
	
	
	
	
	

}
