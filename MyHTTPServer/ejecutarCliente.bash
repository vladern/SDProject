cd autentia-rmi/src
echo -n "IP del rmiregistry:"
read ip
echo -n "Numero de hilos:"
read hilos
echo -n "puerto del Controler:"
read controler
java -cp . com.autentia.rmi.ClientMain $ip $hilos $controler
