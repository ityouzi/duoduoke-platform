#!/bin/sh

rm -f tpid

JAVA_OPTS=" -server -Xms512m -Xmx1g -Xss256k "

JAVA_DEBUG_OPTS=""
if [[ "$1" = "debug" ]]; then
     JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=9888,server=y,suspend=n "
fi



nohup java $JAVA_OPTS $JAVA_DEBUG_OPTS   -jar   duoduoke-web.jar > stdout.log 2>&1 &

echo $! > tpid
echo Start Success!


