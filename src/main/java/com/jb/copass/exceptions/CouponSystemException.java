package com.jb.copass.exceptions;/*
 *Created by User in 7/24/2022
 */

import java.time.LocalDateTime;

public class CouponSystemException extends Exception {

    public CouponSystemException(ErrMsg errMsg)
    {
        super(errMsg.getMsg() +
                "on : " + LocalDateTime.now() + "\n\n");
    }

    public CouponSystemException(LayerMsg layerMsg){
        super(layerMsg.getMsg());
    }


}
