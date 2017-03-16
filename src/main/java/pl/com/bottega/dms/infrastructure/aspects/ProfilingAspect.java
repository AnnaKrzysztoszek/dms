package pl.com.bottega.dms.infrastructure.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by anna on 12.03.2017.
 */
@Component
@Aspect
public class ProfilingAspect {

    @Around("execution(* pl.com.bottega.dms.application..*.*(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
        long ts = new Date().getTime();
        try {
            Object ret = joinPoint.proceed();
            logTime(joinPoint, ts);
            return ret;
        } catch (Throwable ex) {
            logTime(joinPoint, ts);
            throw ex;
        }
    }

    private void logTime(ProceedingJoinPoint joinPoint, long ts) {
        long te = new Date().getTime();
        long t = te - ts;
        String msg = String.format("Execution %s took %s ms", joinPoint.getSignature(), t);
        Logger.getLogger(ProfilingAspect.class).info(msg);
    }

    /*
    @Around("execution(* pl.com.bottega.dms.application..*.*(..)))")
    public Object countTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object output = joinPoint.proceed();
        Instant end = Instant.now();
        System.out.println("Method " + joinPoint.getSignature() + "execution time: " + Duration.between(start, end));
        return output;
    }*/
}
