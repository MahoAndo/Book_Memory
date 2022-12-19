package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 *  CorderConstance
 *  @author maho
 */
@Service
public class CorderConstance {
	
	/**
	 * status
	 * */
	public static final String STATUS_1 = "start";
	public static final String STATUS_2 = "reading";
	public static final String STATUS_3 = "finish";
	
	/**
	 * csv
	 * */
	public static String TYPE_UTIL = MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;
	public static String NEW_LINE = "\r\n";
	public static String CHARACTER = ";charset=utf-8";
}