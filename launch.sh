#!/bin/bash


JAR_NAME="target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar"

# Function to launch a node
launch_node() {
    NODE_NAME="$1"
    gnome-terminal --title="Node: $NODE_NAME" -- bash -c "echo 'Starting NodeMain for node: $NODE_NAME'; java -cp \"$JAR_NAME\":. NodeMain \"$NODE_NAME\"; exec bash" &
    sleep 0.5
}

# Function to launch a client with a given request file.
launch_client() {
    CLIENT_TITLE="$1"
    REQUEST_FILE="$2"
    gnome-terminal --title=\"$CLIENT_TITLE\" -- bash -c "echo 'Starting Client with request file: $REQUEST_FILE'; java -cp \"$JAR_NAME\":. Client \"$REQUEST_FILE\"; exec bash" &
    sleep 0.5
}

# Launch nodes in the required order.
launch_node "NodeA"
launch_node "NodeA1"
launch_node "NodeA2"
launch_node "NodeB"
launch_node "NodeB1"
launch_node "NodeB2"


sleep 2

# Launch clients.
launch_client "Client 1" "client1_requests.txt"
launch_client "Client 2" "client2_requests.txt"
