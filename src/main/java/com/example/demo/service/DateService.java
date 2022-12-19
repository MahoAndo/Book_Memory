package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 *  DateService
 *	@author maho
 */
@Service
public class DateService {
	
	/**
	 *  get now date (Date → String yyyyMMdd)
	 *  @return String nowDate
	 */
	public String getNowDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(date);
		return nowDate;
    }
	
}