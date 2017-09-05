package com.longyuan.my_realm_university.student;

/**
 * Created by loxu on 05/09/2017.
 */

public interface StudentContract {

    interface View{

        void setPresenter(Presenter presenter);
    }

    interface  Presenter{

        void start();

    }
}
