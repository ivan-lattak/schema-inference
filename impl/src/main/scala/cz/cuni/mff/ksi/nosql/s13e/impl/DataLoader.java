package cz.cuni.mff.ksi.nosql.s13e.impl;

import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;

public interface DataLoader {

    RDD<TypedDocument> loadData(SparkContext sc);

}
