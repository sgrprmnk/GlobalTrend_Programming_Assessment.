package com.example.demo;
import java.sql.Date;
import java.time.LocalDateTime;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class CheckAdvice {
private static final Logger log=LoggerFactory.getLogger(CheckAdvice.class);

@Around("@annotation(LogTime)")
public Object checkTime(ProceedingJoinPoint pj) throws Throwable {
	LocalDateTime start=LocalDateTime.now();
	log.info("In method"+pj.getSignature().getName()+" starts at"+start);
	Object oj =pj.proceed();
	
	LocalDateTime end=LocalDateTime.now();
	log.info("In method"+pj.getSignature()+" starts at"+end);
	log.info("method"+pj.getSignature().getName()+" took total time: "+(end.getSecond()-start.getSecond()));
	return oj;
}

@Around("@annotation(LogRequest)")
public Object checkRequest(ProceedingJoinPoint pj) throws Throwable {
	
	ObjectMapper om= new ObjectMapper();
	
	log.info("In method"+pj.getSignature().getName()+" with request as"+ om.writeValueAsString(pj.getArgs()));
	return pj.proceed();
}

@Around("@annotation(LogResponse)")
public Object checkResponse(ProceedingJoinPoint pj) throws Throwable {
ObjectMapper om= new ObjectMapper();
	Object oj=pj.proceed();
	log.info("In method"+pj.getSignature().getName()+" with response as"+ om.writeValueAsString(oj));
	return oj;
}
}
