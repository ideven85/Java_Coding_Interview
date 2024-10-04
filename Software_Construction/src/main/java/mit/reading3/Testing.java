package mit.reading3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Testing {
    static final Logger logger = LogManager.getLogger(Testing.class.getName());

    public int multipication(Class2 class2){
        if(class2==null){
            logger.error("Class Cannot be null");
            System.exit(1);
        }
        return class2.getValue()*2;
    }

    public static void main(String[] args) {
        logger.info("Result:{}", new Testing().multipication(new Class2()));
    }
}
