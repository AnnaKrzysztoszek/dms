package pl.com.bottega.dms.application.user;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by anna on 12.03.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresAuth {

    String[] value() default {};

}
