cd autentia-rmi/src
echo "IP del rmiregistry:"
read ip
java -cp . com.autentia.rmi.ClientMain $ip
