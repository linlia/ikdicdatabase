package org.wltea.analyzer.test;

import java.io.StringReader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKSAnalyzer;

public class TestAnalysis {
	
	public static void main(String[] args)throws Exception {
		
		
		//IKAnalyzer analyzer=new IKAnalyzer(true);
		IKSAnalyzer analyzer=new IKSAnalyzer();
		String temp="去哪里搜索衣服";
		
		testAnalyzer(temp, analyzer);
	//	testAnalyzer(temp, analyzer);
		
		
		
		
		
		
	}
	
	
	public static void  testAnalyzer(String text,IKSAnalyzer analyzer)throws Exception{

		
		TokenStream token=analyzer.tokenStream("", new StringReader(text));
		
		CharTermAttribute term=token.addAttribute(CharTermAttribute.class);
		
		token.reset();
		while(token.incrementToken()){
			System.out.println(term.toString());
		}
		
		token.end();
		token.close();
		
		
		
	}

}
