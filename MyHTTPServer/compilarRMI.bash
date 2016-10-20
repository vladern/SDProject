export PATH=$PATH:/usr/bin/

cd Esclavo
javac IEsclavo.java
echo "$(tput setaf 1)Se ha compilado IEsclavo.java $(tput sgr 0)"
export CLASSPATH=$CLASSPATH:/Escritorio/rmi/Esclavo/IEsclavo
echo "$(tput setaf 1)CLASSPATH"$CLASSPATH"$(tput sgr 0)"
javac Esclavo.java
echo "$(tput setaf 1)Se ha compilado el Esclavo.java $(tput sgr 0)"
rmic Esclavo
echo "$(tput setaf 1)Se ha creado el skeleton del Esclavo.class$(tput sgr 0)"
#unset CLASSPATH
cd ..
jar cvf cliente.jar Esclavo/IEsclavo.class
#export CLASSPATH=$CLASSPATH:/home/vladernn/Escritorio/rmi/cliente.jar
#echo "$(tput setaf 1)CLASSPATH"$CLASSPATH"$(tput sgr 0)"
cd Controler
javac -cp /home/vladernn/Escritorio/rmi/cliente.jar IRegistradorRemoto.java



#echo "$(tput setaf 1)Se ha compilado el IRegistradorRemoto.java $(tput sgr 0)"
#unset CLASSPATH
#cd ..
#jar cvf paraRegistradorRemoto.jar Esclavo/IEsclavo.class Controler/IRegistradorRemoto.class 
#export CLASSPATH=$CLASSPATH:/home/vladernn/Escritorio/rmi/paraRegistradorRemoto.jar
#cd Controler
#javac RegistradorRemoto.java
#echo "Se ha compilado el RegistradorRemoto.java"
#rmic RegistradorRemoto
#echo "Se ha generado el Skeleton del RegistradorRemoto.class"
#cd ..
#jar cvf cliente.jar Controler/IRegistradorRemoto.class Controler/RegistradorRmoto_Stub.class Esclavo/IEsclavo.class Esclavo/Esclavo_Stub.class
#unset CLASSPATH
#export CLASSPATH=$CLASSPATH:/home/vladernn/Escritorio/rmi/cliente.jar
#cd Controler
#javac RegistrarRR.java
#cd ..
#cd Esclavo 
#javac RegistrarEsclavo.java
#cd ..
#cd Controler
#javac Cliente.java
#cd ..
unset PATH
unset CLASSPATH
#rm -rf *.jar */


