package pl.excercise.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerFullName {

    @Value("#{target.firstName+' '+target.surname}")
    String getFullName();

}
