# edu.uga.miashs.dapp

Ce projet a été réalisé comme projet d’étude au sein de l’Université Grenoble Alpes et niveau de la licence MIASHS. C’est un prototype d’une application décentralisée qui est pensée comme un jeu de carte à collectionner. Le projet utilise java, le langage de script solidity de la plateforme Ethereum ainsi que la librarie web3j comme interface java/Ethereum.

Le projet n’est pas abouti à ce jour, il peut être pour autant utile dans la compréhension des mécanismes de la blockchain Ethereum et de l’interface possible avec Java.

POUR UTILISER L’APPLICATION PLUSIEURS ÉTAPES SONT NÉCESSAIRES :

Vous devez utiliser un client Ethereum, le projet utilise Infura (https://infura.io/).
L’utilisation d’autres clients est possible voir : https://docs.web3j.io/getting_started.html#start-a-client

Le projet est connecté au tesnet rinkeby, paramétrez selon vos préférence la connection au sein de la class : LinkEthereum.


Pour utiliser l’application il vous faut un porte feuille, il est possible d’en créer un localement avec l’application web3j : https://docs.web3j.io/command_line.html.

Il sera nécessaire d’utiliser vos propre identifiants quand vous faites appel à la class Ident.

Afin de pouvoir utiliser le gaz nécessaire au fonctionnement aux appels sur la blockchain, créditez votre compte : https://www.rinkeby.io/#faucet.

Pour avoir des informations complémentaires, le lien vers un projet dont nous sommes parti : https://github.com/web3j/sample-project-gradle.


COMMENT GÉNÉRER UNE CLASS SMART CONTRACT SUR JAVA ?

installer solc (voir remix)
installer node pour exécuter solcjs

cd /usr/local/lib/node_modules/solc

compiler avec solcjs : solcjs ../edu.uga.miashs.dapp/contracts/<contract>.sol --bin --abi --optimize -o ../edu.uga.miashs.dapp/contracts

Renomer les fichiers générés.

cd ../web3j-3.2.0/bin

transformer avec web3j : 

sh web3j solidity generate --solidityTypes ../contracts/Card.bin ../contracts/Card.abi -p edu.uga.miashs.dapp -o ../src/main/java/edu/uga/miashs/contracts


UTILISER L'IHM : 

Pour utiliser la partie IHM de notre programme il est nécessaire d’avoir la librairie java FX.




