package org.veight.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class MyLog {
	Logger logger = Logger.getLogger(MyLog.class);
	String logStr = null ;
	
	
	public void doBefore(JoinPoint jp) {
		logStr = jp.getTarget().getClass().getName()
				+ jp.getSignature().getName()+"  ***Start***";
		logger.info(logStr);
	}
	
	
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    	
    	Object result=null;
		try{  
			result = pjp.proceed();  
		}catch(Exception e){  
			logStr = pjp.getTarget().getClass() + "." + pjp.getSignature().getName()+ "()  ";
			logStr = logStr+"异常["+e+"]";
			logger.info(logStr); 
		}
  
        return result;
    }
    
    
    public void doAfter(JoinPoint jp) {
    	logStr =jp.getTarget().getClass().getName()
    			+ jp.getSignature().getName() +"**End***";
    	logger.info(logStr);
    }
    
    
}
