export PATH=$PATH:usr/bin
javac InterfazRemoto.java
export CLASSPATH=$CLASSPATH:/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/Controler/Servidor/InterfazRemoto
javac ObjetoRemoto.java
rmic ObjetoRemoto
jar cvf cliente.jar InterfazRemoto.class ObjetoRemoto_Stub.class
javac Registro.java
export CLASSPATH=$CLASSPATH:/home/vladernn/Escritorio/ProyectoSD/project/SDProject/MyHTTPServer/Controler/Servidor/cliente.jar
echo $CLASSPATH
unset CLASSPATH
rmiregistry –J-Djava.security.policy=registrar.policy