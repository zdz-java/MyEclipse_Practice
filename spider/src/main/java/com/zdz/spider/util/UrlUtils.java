package com.zdz.spider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.commons.lang3.StringUtils;

public class UrlUtils {

	private static Pattern patternForHrefWithQuote = Pattern.compile("(<a[^<>]*href=)[\"']([^\"'<>]*)[\"']", Pattern.CASE_INSENSITIVE);
    private static Pattern patternForHrefWithoutQuote = Pattern.compile("(<a[^<>]*href=)([^\"'<>\\s]+)", Pattern.CASE_INSENSITIVE);

//	该方法为拷贝webmagic项目的
	public static String fixAllRelativeHrefs(String content, String url) {
//		content = replaceByPattern(content, url, patternForHrefWithQuote);
//		content = replaceByPattern(content, url, patternForHrefWithoutQuote);
        return content;
	}
//	public static String replaceByPattern(String html, String url, Pattern pattern) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Matcher matcher = pattern.matcher(html);
//        int lastEnd = 0;
//        boolean modified = false;
//        while (matcher.find()) {
//            modified = true;
//            stringBuilder.append(StringUtils.substring(html, lastEnd, matcher.start()));
//            stringBuilder.append(matcher.group(1));
////            stringBuilder.append("\"").append(canonicalizeUrl(matcher.group(2), url)).append("\"");
//            lastEnd = matcher.end();
//        }
//        if (!modified) {
//            return html;
//        }
//        stringBuilder.append(StringUtils.substring(html, lastEnd));
//        return stringBuilder.toString();
//    }
}
