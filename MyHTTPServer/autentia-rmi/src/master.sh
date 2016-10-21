#!/bin/sh

if [ -z "$1" ]; then
	echo "Usage: master.sh master_host_ip"
	echo "   master_host_ip   the ip of the host where you are running this script (master.sh)"
	exit 1
fi

rmiregistry &

java -cp . -Djava.rmi.server.hostname=$1 com.autentia.rmi.MasterMain

killall rmiregistry
