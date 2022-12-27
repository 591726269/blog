package com.example.blog.utils;

import org.springframework.beans.BeanUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * 复制对象或集合属性
 * @author Wuzp
 * @date 2022/12/22 13:53
 */

public class BeanCopyUtils {
    /**
     * 复制对象
     *
     * @param source 源
     * @param target 目标
     * @return {@link T}
     */
    public static <T> T copyObject(Object source,Class<T> target){
        T temp = null;
        try {
            temp = target.newInstance();
            if (null != source){
                BeanUtils.copyProperties(source,temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 拷贝集合
     *
     * @param source 源
     * @param target 目标
     * @return {@link List<T>} 集合
     */
    public static <T,S>List<T> copyList(List<S> source,Class<T> target){
       List<T> list = new ArrayList<>();
       if (null != source && source.size() > 0){
           for (Object obj : source){
               list.add(BeanCopyUtils.copyObject(obj,target));
           }
       }
       return  list;
    }
}
