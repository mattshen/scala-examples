#!/usr/bin/env sh

set -e

$SPARK_HOME/bin/spark-submit \
  --class "sparkapp01.SimpleApp" \
  --master "local[4]" \
  target/scala-2.11/01-spark-app-helloworld_2.11-0.1.jar
