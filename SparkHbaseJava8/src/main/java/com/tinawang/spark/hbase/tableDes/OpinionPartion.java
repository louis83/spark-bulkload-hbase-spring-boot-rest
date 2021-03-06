package com.tinawang.spark.hbase.tableDes;

import scala.Tuple2;

/**
 * Created by wangting26 on 2017/9/30.
 */
public class OpinionPartion extends TablePartion{

    public OpinionPartion(int partions){
        super(partions);
    }

    @Override
    public int getPartition(Object key){
        if(key == null){
            return 0;
        }else if(key instanceof Tuple2){
            @SuppressWarnings("unchecked")
            Tuple2<String,String> tuple2 = (Tuple2<String,String>) key;
            return Integer.parseInt(tuple2._1().substring(0,1)); // 取第一位salt
        }else {
            return Integer.parseInt((String) key.toString().substring(0,1));
        }
    }


}
