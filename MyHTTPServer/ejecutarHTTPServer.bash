echo -n "IP del controler:"
read controler
echo -n "puerto del controler:"
read conrolerPort
echo -n "tu puerto:"
read port
java MyHTTPServer $contrloler $controlerPort $port
