package cz.cuni.mff.ksi.nosql.s13e.impl;

import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

public interface DataLoader {

    RDD<TypedDocument> loadData(SparkSession sparkSession);

}
