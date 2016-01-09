package com.base.ServletTest;

import com.base.SpringServiceTest.SpringServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liumin on 15/12/28.
 */


public class Test1 {

    SpringServiceTest springServiceTest;

    @Autowired
    public Test1( SpringServiceTest springServiceTest ){
        this.springServiceTest = springServiceTest;
        this.springServiceTest.TrgetUser();
    }

}
