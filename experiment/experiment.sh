#!/bin/bash

cd "$(dirname "$0")"

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

cd ..
ROOT_DIR=$(pwd)
for experiment in ${EXPERIMENTS}; do
    ./gradlew \
        -PallApproaches.dbName=${experiment} \
        -Psevilla.outputFile=${ROOT_DIR}/experiment/output/${experiment}-sevilla.xml \
        -Pbaazizi.outputFile=${ROOT_DIR}/experiment/output/${experiment}-baazizi.txt \
        -Pbaazizi.equivalence=l \
        -Pcanovas.outputFile=${ROOT_DIR}/experiment/output/${experiment}-canovas.xml \
        -Pfrozza.outputFile=${ROOT_DIR}/experiment/output/${experiment}-frozza.json \
        -PschemaInference.outputFile=${ROOT_DIR}/experiment/output/${experiment}-new.xml \
        run
done
