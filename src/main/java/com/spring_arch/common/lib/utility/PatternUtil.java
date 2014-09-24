/**
 * @file		PatternUtil.java
 * @brief   패턴관련 
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.spring_arch.common.lib.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {

	/**
	 * 패턴 매칭
	 * @param sourceMessage
	 * @param replaceMessage
	 * @param pattern
	 * @return String
	 */
	public static String messageReplace ( String sourceMessage, String replaceMessage, String pattern ) throws Exception {
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sourceMessage);
		replaceMessage = replaceMessage.replaceAll("\\$","\\\\\\$");
		String targetValue = m.replaceAll(replaceMessage);
		//String targetValue = Matcher.quoteReplacement (replaceMessage);
		return targetValue;
	}

	/**
	 * 첫번째 문자열만 패턴 매칭: 대소문자 구분없음
	 * @param sourceMessage
	 * @param replaceMessage
	 * @param pattern
	 * @return String
	 */
	public static String messageReplaceFirst ( String sourceMessage, String replaceMessage, String pattern ) throws Exception {
		
		if((sourceMessage.toUpperCase()).startsWith(pattern)) {
			Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(sourceMessage);
			return m.replaceFirst(replaceMessage);
		}

		return sourceMessage;
	}

	@SuppressWarnings("rawtypes")
	public static String messageReplaceMap( HashMap <String, String> param, String source ) throws Exception {
		
		String source_temp = source;
		
		for ( Iterator<?> iter = param.entrySet().iterator(); iter.hasNext();) {            
		    
			Map.Entry entry = (Map.Entry) iter.next();                                        
		    String  key = "#"+(String)entry.getKey()+"#";
		    String value = "";
		    if( "java.lang.Long".equals(entry.getValue().getClass().getName())){
		    	value =  String.valueOf(entry.getValue());
		    } else {
		    	value = (String)entry.getValue();	
		    }
		    
		    source_temp = messageReplace( source_temp, value, key );
		    
		}
		
		return source_temp;
	}
	
	
}
