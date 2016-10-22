cd autentia-rmi/src
echo "IP del rmiregistry:"
read ip1
echo "IP de donde estas:"
read ip2
echo "dame nombre:"
read nombre
java -cp . -Djava.rmi.server.hostname=$ip2 com.autentia.rmi.SlaveMain $ip1 $nombre
