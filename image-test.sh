#!/bin/sh

result=$( docker images -q <imagename> )

if [[ -n "$result" ]]; then
    echo 'Container image exist'
else 
    echo 'No such container image'
fi