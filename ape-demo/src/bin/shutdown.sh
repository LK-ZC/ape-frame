#!/bin/sh
#项目名
PROJECT_NAME="ape-demo"
#判断是否启动过
PID=$(ps -ef|grep java|grep $PROJECT_NAME  |awk '{print $2}')
if [ "${PID}" != "" ]; then
    echo "Service was running, could shutdown"
    kill "${PID}"
    exit 0;
fi