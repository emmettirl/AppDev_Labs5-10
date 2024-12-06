package app.dev.labs.appdev_labs510.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before(value = "execution(* app.dev.labs.appdev_labs510.daos.HouseholdRepository.findHouseholdsWithNoPets(..))")
    public void logHouseholdsWithNoPets(JoinPoint joinPoint) {
        log.info("Before: {} executing with arguments {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After(value = "execution(* app.dev.labs.appdev_labs510.daos.HouseholdRepository.findHouseholdsWithNoPets(..))")
    public void logHouseholdsWithNoPetsAfter(JoinPoint joinPoint) {
        log.info("After: {} executed with arguments {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(value = "execution(* app.dev.labs.appdev_labs510.daos.HouseholdRepository.findHouseholdsWithNoPets(..))", returning = "result")
    public void logHouseholdsWithNoPetsAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("AfterReturning: {} executed with arguments {} and returned {}", joinPoint.getSignature().getName(), joinPoint.getArgs(), result);
    }

    @AfterThrowing(value = "execution(* app.dev.labs.appdev_labs510.daos.HouseholdRepository.findHouseholdsWithNoPets(..))", throwing = "exception")
    public void logHouseholdsWithNoPetsAfterThrowing(JoinPoint joinPoint, Exception exception) {
        log.error("AfterThrowing: {} executed with arguments {} and threw exception {}", joinPoint.getSignature().getName(), joinPoint.getArgs(), exception);
    }

    @Around(value = "execution(* app.dev.labs.appdev_labs510.daos.HouseholdRepository.findHouseholdsWithNoPets(..))")
    public Object logHouseholdsWithNoPetsAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around: {} executing with arguments {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
        Object result = joinPoint.proceed();
        log.info("Around: {} executed with arguments {} and returned {}", joinPoint.getSignature().getName(), joinPoint.getArgs(), result);
        return result;
    }


    @Before(value = "execution(* app.dev.labs.appdev_labs510.security.MyUserDetailsService.loadUserByUsername(..))")
    public void logUserDetails(JoinPoint joinPoint) {
        log.info("Before: {} executing with arguments {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
}

