package sj.learning.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {
	

	//@Before(value="execution(* sj.learning..set*(..)) || args(name)")    //Simple pointcut which intercept all the set methods in specific pakage,
	@Before(value="allGetters() || allShip()") // combine multible pointcuts in single advice
	public void log(JoinPoint joinPoint){
		Object param = (joinPoint.getArgs()!=null && joinPoint.getArgs().length>0) ? joinPoint.getArgs()[0] : "";
		if(param!=null && !"".equals(param))
			System.out.println("params "+param);
	}
	
	//@AfterReturning(pointcut="allShip() && args(name)",returning="returnValue")
	@AfterReturning(pointcut="@annotation(sj.learning.aop.Loggable) && args(name)",returning="returnValue") // Using custom annotations
	public void print(String name,String returnValue){
		System.out.println("param :"+name+", return:"+returnValue);
	}
	
	@Around("allShip() || allGetters()")
	public Object print(ProceedingJoinPoint proceedingJoinPoint){
		Object o = null;
		try {
			Object param = (proceedingJoinPoint.getArgs()!=null && proceedingJoinPoint.getArgs().length>0) ? proceedingJoinPoint.getArgs()[0] : "";
			if(param!=null && !"".equals(param))
				System.out.println("around >> params "+param);
				o = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@Pointcut("execution(public * get*(..))")
	public void allGetters(){}
	
	@Pointcut("within(sj.learning.aop.model.Ship)")
	public void allShip(){}

}
