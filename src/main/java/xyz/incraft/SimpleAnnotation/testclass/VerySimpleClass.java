package xyz.incraft.SimpleAnnotation.testclass;

import org.springframework.stereotype.Component;

/**
 * Created by Михаил on 20.01.2016.
 *
 */
@Component
public class VerySimpleClass {

    public VerySimpleClass() {
    }

    public int ReturnValue(){
        return 5;
    }

    public int Add(int a, int b){
        return a+b;
    }
}
