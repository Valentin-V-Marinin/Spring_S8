package seminar8.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class TrackUserActionAspect {


        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @Before("@annotation(seminar8.aop.TrackUserAction)")
        public void TrackUserActionBefore(JoinPoint joinPoint) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = Date.from(Instant.now());
            logger.info("Action at: {} / signature: {} / args: {} ",
                    df.format(start), joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
        }
}
