cd autentia-rmi
cd src
echo -n "IP local:"
read ip
rmiregistry & java -cp . -Djava.rmi.server.hostname=$ip com.autentia.rmi.MasterMain
