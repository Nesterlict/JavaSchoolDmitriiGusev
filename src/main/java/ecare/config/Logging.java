package ecare.config;

/**
 * Created by Artyom Karnov on 9/30/16.
 * artyom-karnov@yandex.ru
 **/

import ecare.MVC.entities.User;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Class for logging functionality
 */
@Aspect
public class Logging {
    private static final Logger logger = LogManager.getLogger(Logging.class);

    /**
     * Pointcut at createEntity action
     */
    @Pointcut("execution(* ecare.services.api.create*(*))")
    public void createEntityPointcut() {
    }

    /**
     * Pointcut at getEntity action
     */
    @Pointcut("execution(* ecare.services.api.get*(..))")
    public void getEntityPointcut() {
    }

    /**
     * Pointcut at updateEntity action
     */
    @Pointcut("execution(* ecare.services.api.update*(*))")
    public void updateEntityPointcut() {
    }

    /**
     * Pointcut at deleteEntity action
     */
    @Pointcut("execution(* ecare.services.api.delete*(*))")
    public void deleteEntityPointcut() {
    }

    /**
     * Method for logging BeforeCreateAdvice
     *
     * @param joinPoint Aspect join point
     */
    @Before("createEntityPointcut()")
    public void loggingBeforeCreateAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging AfterCreateAdvice
     *
     * @param joinPoint Aspect join point
     */
    @After("createEntityPointcut()")
    public void loggingAfterCreateAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is created", Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging BeforeGetAdvice
     *
     * @param joinPoint Aspect join point
     */
    @Before("getEntityPointcut()")
    public void loggingBeforeGetAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging AfterGetAdvice
     *
     * @param user
     */

    @AfterReturning(pointcut = "getEntityPointcut()", returning = "user")
    public void loggingAfterGetAdvice(User user) {
        logger.info(String.format("Entity %s has been found", user));
    }

    /**
     * Method for logging BeforeUpdateAdvice
     *
     * @param joinPoint Aspect join point
     */
    @Before("updateEntityPointcut()")
    public void loggingBeforeUpdateAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging AfterUpdateAdvice
     *
     * @param joinPoint Aspect join point
     */
    @After("updateEntityPointcut()")
    public void loggingAfterUpdateAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is updated", Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging BeforeDeleteAdvice
     *
     * @param joinPoint Aspect join point
     */
    @Before("deleteEntityPointcut()")
    public void loggingBeforeDeleteAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging AfterDeleteAdvice
     *
     * @param joinPoint Aspect join point
     */
    @After("deleteEntityPointcut()")
    public void loggingAfterDeleteAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is deleted", Arrays.toString(joinPoint.getArgs())));
    }

    /**
     * Method for logging exceptions
     *
     * @param joinPoint Aspect join point
     */
    @AfterThrowing(value = "execution(* ecare.services.*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Exception ex) {
        logger.error(String.format("Exception was thrown at the method: %s with message {%s}",
                joinPoint.toString(), ex.getMessage()));
        logger.error("Problems: ");
        for (StackTraceElement b : ex.getStackTrace()) {
            logger.error("at " + b);
        }
    }
}
