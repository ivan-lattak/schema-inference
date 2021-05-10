package cz.cuni.mff.ksi.nosql.s13e.api;

import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

public interface DataLoader {

    RDD<TypedDocument> loadData(SparkSession sparkSession);

}
