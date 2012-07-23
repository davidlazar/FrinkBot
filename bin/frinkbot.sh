#!/bin/bash

for dir in build/artifacts build/lib; do
    for jarfile in $dir/*.jar; do
        CLASSPATH=$CLASSPATH:$jarfile
    done
done

exec java -cp $CLASSPATH FrinkBot $*
