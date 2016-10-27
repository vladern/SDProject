cd Controler
cd autentia-rmi
cd src
echo -n "IP local:"
read ip
echo -n "port:"
read port
rmiregistry $port & java -cp . -Djava.rmi.server.hostname=$ip com.autentia.rmi.MasterMain
