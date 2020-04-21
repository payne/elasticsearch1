# Elastic Search Learning Toy

Steps to try this out:
1. `docker-compose up -d`
1.  Wait about five to ten minutes for Kibana to start (it's slow to start) and then visit http://localhost:5601/
1. There's an option to import a dataset -- choose the air planes data set
1. Run `ElasticsearchApplication` and enjoy this fine output:
```
Running!
searchRequest=SearchRequest{searchType=QUERY_THEN_FETCH, indices=[], indicesOptions=IndicesOptions[ignore_unavailable=false, allow_no_indices=true, expand_wildcards_open=true, expand_wildcards_closed=false, allow_aliases_to_multiple_indices=true, forbid_closed_indices=true, ignore_aliases=false, ignore_throttled=true], types=[], routing='null', preference='null', requestCache=null, scroll=null, maxConcurrentShardRequests=0, batchedReduceSize=512, preFilterShardSize=128, allowPartialSearchResults=null, localClusterAlias=null, getOrCreateAbsoluteStartMillis=-1, source={"query":{"bool":{"must":[{"match_all":{"boost":1.0}}],"adjust_pure_negative":true,"boost":1.0}}}}
searchRequest.source()={"query":{"bool":{"must":[{"match_all":{"boost":1.0}}],"adjust_pure_negative":true,"boost":1.0}}}
numHits=13095
```

# References
1. I got the docker compose from https://www.elastic.co/guide/en/elastic-stack-get-started/current/get-started-docker.html 
it is quick to get started!   


# Notes
1. `docker-compose down -v` to delete the volumes when taking the containers down.
1. I put files in ~/es on my Mac MINI.

