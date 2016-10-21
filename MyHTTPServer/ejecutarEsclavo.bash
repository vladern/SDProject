cd autentia-rmi/src
echo "IP del rmiregistry:"
read ip1
echo "IP de donde estas:"
red ip2
java -cp . -Djava.rmi.server.hostname=$ip2 com.autentia.rmi.SlaveMain $ip1 Slave-1
