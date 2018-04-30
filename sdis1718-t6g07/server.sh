#!/bin/bash

# argument 1: id of peer
# argument 2: access point of peer (rmi object name)

java -cp ./bin backup.Peer 1.0 $1 $2 233.252.10.2 1234 233.252.10.3 1234 233.253.10.1 1234
