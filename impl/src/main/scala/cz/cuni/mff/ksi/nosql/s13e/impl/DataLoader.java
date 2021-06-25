package cz.cuni.mff.ksi.nosql.s13e.impl;

import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;

public interface DataLoader {

    /**
     * Represents a method how to retrieve data from a data source into an {@link RDD}.
     *
     * @param sc {@link SparkContext} connected to an active Spark session that should be used to create the
     *           {@link RDD}. Any data manipulation and transformation can be performed using the
     *           provided SparkContext to speed it up. The implementation can create any number of
     *           RDDs. It must never {@link SparkContext#stop() stop} the context or perform any
     *           similar disruptive operation.
     * @return and {@link RDD} containing {@link TypedDocument typed documents} representing the retrieved data.
     */
    RDD<TypedDocument> loadData(SparkContext sc);

}
