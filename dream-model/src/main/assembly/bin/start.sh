#!/bin/bash
cd `dirname $0`
source /etc/profile
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf


PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The server already started!"
    echo "PID: $PIDS"
    exit 1
fi

LOGS_DIR=""
if [ -n "$LOGS_FILE" ]; then
    LOGS_DIR=`dirname $LOGS_FILE`
else
    LOGS_DIR=$DEPLOY_DIR/logs
fi
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log

LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_OPTS="$JAVA_OPTS -Duser.timezone=Asia/Shanghai -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
fi
JAVA_MEM_OPTS="${JAVA_MEM_OPTS}"
#BITS=`java -version 2>&1 | grep -i 64-bit`
#if [ -n "$BITS" ]; then
#    JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
#else
#    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g  -XX:SurvivorRatio=2 -XX:+UseParallelGC "
#fi

SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:=prod}

echo -e "Starting the server ...\c"

CMD="java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -classpath $CONF_DIR:$LIB_JARS \
-Dloader.config.location=${CONF_DIR}/loader.properties \
org.springframework.boot.loader.PropertiesLauncher"

if [ "$1" = "run" ]; then
    $CMD
else
    #nohup $CMD > $STDOUT_FILE 2>&1 &
    nohup $CMD > /dev/null &

    echo "OK!"
    PIDS=`ps -ef | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
    echo "PID: $PIDS"
    echo "STDOUT: $STDOUT_FILE"
fi


