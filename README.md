Running the Distributed Shared Memory Project

Prerequisites: 
• Maven must be installed. You can verify your installation by running "mvn --version" in a terminal.
• Make is required to compile the project. Ensure it is installed on your system.
• A compatible Java version should be installed.
• You will also need a terminal emulator (e.g., gnome-terminal) if you plan to launch multiple windows.

Building the Project:

Open a terminal in the root directory of the project.

Run the command "make" to compile the entire project. This command uses Maven to build the project and will generate the JAR file at: target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar

Running the Project:

Step 1 – Start the Configuration Server: 
• In your project directory, run the script "run-configserver.sh" (i.e., type "./run-configserver.sh" in your terminal).
• The configuration server distributes the node configuration to all nodes. Keep this terminal open while the project is running.

Step 2 – Launch Nodes and Clients Together:
• Open a new terminal window.
• In the project directory, run "launch.sh" by typing "./launch.sh". This script will open separate terminal windows to launch the following nodes in order: NodeA, NodeA1, NodeA2, NodeB, NodeB1, NodeB2.
• After all nodes start, the script will also launch two clients. One client will use "client1_requests.txt" and the other will use "client2_requests.txt".

Alternative – Running Nodes and Clients Individually: If you prefer to start each component separately, you can use the provided scripts:
• To run an individual node, open a terminal window for each node and type:
./run-node.sh NodeA
./run-node.sh NodeA1
./run-node.sh NodeA2
./run-node.sh NodeB
./run-node.sh NodeB1
./run-node.sh NodeB2

(Each command starts NodeMain for the specified node with the JAR file "target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar" on the classpath.)

• To run a client individually, open a new terminal window for each client and type:
./run-client.sh client1_requests.txt
./run-client.sh client2_requests.txt
(Each command launches a Client process using the provided request file.)

