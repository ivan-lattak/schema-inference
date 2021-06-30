#!/bin/bash

EXPERIMENTS="experimentPrimitiveTypes
             experimentSimpleArrays
             experimentSimpleObjects
             experimentComplexArrays
             experimentComplexObjects
             experimentReferences
             experimentOptional
             experimentUnion"
           
for experiment in ${EXPERIMENTS}; do
    DROP_CMD="${DROP_CMD}
    use ${experiment}
    db.dropDatabase()"
done
echo "${DROP_CMD}" | mongo

for experiment in $EXPERIMENTS; do
    mongoimport --jsonArray \
        --db $experiment \
        --collection articles \
        --file ${experiment}.json
done
