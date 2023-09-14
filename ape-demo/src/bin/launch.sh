#!/bin/sh

PROFILE=beta

#项目名
PROJECT_NAME="ape-demo"
MAIN_CLASS="com.jingdianjichi.user.DemoApplication"

echo PROJECT_NAME=${PROJECT_NAME}

if [ -d "logs" ]
then
 mkdir -p logs
fi

#判断是否启动过
PID=$(ps -ef|grep java|grep $PROJECT_NAME  |awk '{print $2}')
if [ "${PID}" != "" ]; then
    echo "Service Have StartUp !!!"
    exit 0;
fi

CURRENT_DICT=`pwd`
echo $CURRENT_DICT

#设置ClassPath
CLASSPATH=${CURRENT_DICT}/conf
echo CLASSPATH=${CLASSPATH}

LIBDIRS=${CURRENT_DICT}/lib
for JARS in ` ls ${LIBDIRS} `
do
CLASSPATH=${CLASSPATH}:${LIBDIRS}/${JARS}
done

#内存设置
JAVA_OPT="-Xmx1024m -Xms512m -Xmn256m -Dfile.encoding=UTF-8 -Dspring.profiles.active="${PROFILE}
#执行
java ${JAVA_OPT} -cp ${CLASSPATH} ${MAIN_CLASS}  >> /dev/null &
