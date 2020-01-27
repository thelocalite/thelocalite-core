package core.log;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * LoggerApsect
 */
@Component
@Aspect
public class LoggerApsect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(core..*.*)")
    public void definePackagePointcuts(){
        // To be left empty
    }

    @After("definePackagePointcuts()") // Advice
    public void logAfter(JoinPoint jp){
        log.debug("\n \n \n");
		log.debug("\n*********** After Method Execution ************\n"
				+ "{}.{}() with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), 
				Arrays.toString(jp.getArgs()));
		log.debug("\n______________________________________________ \n \n \n");
    }

}