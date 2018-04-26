# Neo4JComparison

## 1. Prerequisite

To use this code you will need:

* Maven
* Docks
* Java

## 2. Setting Up the Database


Initially download the required files from:

https://github.com/datsoftlyngby/soft2018spring-databases-teaching-material/tree/master/data

After the files has been downloaded (specifically social_network_nodes.csv), we then unpack the files. 

`
sed -i -E '1s/.*/:ID,name,job,birthday/' social_network_nodes.csv
sed -i -E '1s/.*/:START_ID,:END_ID/' social_network_edges.csv
`

We then need to create the container and fill it with the data, using the following commnad.

`
docker run \
    -d --name neo4j \
    --rm \
    --publish=7474:7474 \
    --publish=7687:7687 \
    --volume=$(pwd)/import:/import \
    --volume=$(pwd)/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/class \
    --env=NEO4J_dbms_security_procedures_unrestricted=apoc.\\\*,algo.\\\* \
    --env=NEO4J_dbms_memory_pagecache_size=6G \
    --env=NEO4J_dbms_memory_heap_max__size=10G \
    neo4j

docker exec neo4j sh -c 'neo4j stop'
docker exec neo4j sh -c 'rm -rf data/databases/graph.db'

docker exec neo4j sh -c 'neo4j-admin import \
    --nodes:Person /import/social_network_nodes.csv \
    --relationships:ENDORSES /import/social_network_edges.csv \
    --ignore-missing-nodes=true \
    --ignore-duplicate-nodes=true \
    --id-type=INTEGER'
`
    
    
