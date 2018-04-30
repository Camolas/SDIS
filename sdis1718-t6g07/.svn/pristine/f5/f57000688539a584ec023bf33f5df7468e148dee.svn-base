Project 1 -- Distributed Backup Service


Instructions for compiling and running:

NOTE: All commands and scripts assume that the current directory is the project folder.

To compile (compile.sh):
mkdir -p bin
javac -d bin src/backup/*.java src/backup/listeners/*.java src/backup/responseHandlers/*.java src/backup/initiators/*.java

Init rmi registry (init_rmi.sh):
cd ./bin/
rmiregistry 1051 &

To run a peer (server.sh, two arguments - id and rmi object name):
java -cp <bin_folder> backup.Peer <version> <id> <rmi_ap> <MC_addr> <MC_port> <MDB_addr> <MDB_port> <MDR_addr> <MDR_port>

To run the testing application:
java -cp <bin_folder> backup.TestApp <peer_ap> <sub_protocol> <opnd_1> <opnd_2>

In the /files folder are some sample files to test the application.




Authors: 
Manuel Curral, 201202445
Pedro Ferreira, 201103084
 
t6-g07, SDIS 2017-2018
