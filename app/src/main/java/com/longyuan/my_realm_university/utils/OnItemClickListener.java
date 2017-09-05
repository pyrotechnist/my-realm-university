package com.longyuan.my_realm_university.utils;

import com.longyuan.my_realm_university.model.DisplayItem;
import com.longyuan.my_realm_university.model.University;

/**
 * Created by loxu on 17/08/2017.
 */

public interface OnItemClickListener {

    void onItemClick(DisplayItem item);

    void onItemLongClick(DisplayItem item,int position);


}
