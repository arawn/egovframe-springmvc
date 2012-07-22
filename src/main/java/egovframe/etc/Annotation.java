package egovframe.etc;

import org.springframework.core.Ordered;

public class Annotation implements Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

}