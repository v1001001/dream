#!/bin/bash
cd `dirname $0`
CONF_DIR=../conf

# JavaAgent: Add JAVA_OPTS with CAT client-agent & client-plugin
# Example: loader.properties
#     javaagent=/data/appdatas/javaagent
JAVA_AGENT_DIR=`awk -F = /^javaagent=.*$/'{print $2}' ${CONF_DIR}/loader.properties`
if [ -d "$JAVA_AGENT_DIR" ] && [ -f "$JAVA_AGENT_DIR/aop.xml" ]; then
    echo "JAVA_AGENT_DIR: ${JAVA_AGENT_DIR}"
    JAVA_OPTS="$JAVA_OPTS -javaagent:${JAVA_AGENT_DIR}/cat-client-agent-0.0.1-SNAPSHOT.jar=${JAVA_AGENT_DIR}/catagent-conf.properties  -javaagent:${JAVA_AGENT_DIR}/aspectjweaver-1.8.10.jar -Dorg.aspectj.weaver.loadtime.configuration=file:${JAVA_AGENT_DIR}/aop.xml  -Daj.weaving.loadersToSkip=sun.misc.Launcher$ExtClassLoader,*.*.*ClassLoader"
	export JAVA_OPTS
fi

# Use JAVA_OPTS in start.sh
./start.sh
