#!/bin/sh

result=$( docker inspect -f '{{.State.Running}}' <containername> )

if [[ $result == "true" ]]; then
    echo "Container is running"
else 
    echo "Container failed"
fi
